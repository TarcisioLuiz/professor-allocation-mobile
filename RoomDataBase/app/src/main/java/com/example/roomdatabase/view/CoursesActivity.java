package com.example.roomdatabase.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.config.RetrofitConfig;
import com.example.roomdatabase.model.Course;
import com.example.roomdatabase.service.CourseService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursesActivity extends AppCompatActivity {

    private RetrofitConfig retrofitConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        retrofitConfig = new RetrofitConfig();
        requestBuscarTodosOsCursos();



    }

    private void requestBuscarTodosOsCursos(){

        CourseService service = retrofitConfig.getCourseService();
        service.getAll().enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {

                if(response.isSuccessful()){
                    List<Course> list =  response.body();

                    for(Course course : list) {
                        Log.d(CoursesActivity.class.getSimpleName(), course.getName());
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Erro: " + response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.e(CoursesActivity.class.getSimpleName(), "Erro de comunicação " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Erro de comunicação com o servidor!  ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}