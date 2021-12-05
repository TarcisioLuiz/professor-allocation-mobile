package com.example.roomdatabase.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.roomdatabase.config.BancoDeDados;
import com.example.roomdatabase.databinding.ActivityMainBinding;
import com.example.roomdatabase.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    private BancoDeDados db;
    private ArrayList<String> dataSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        db = Room.databaseBuilder(getApplicationContext(),
                BancoDeDados.class,
                "dbMamute")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        dataSet = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataSet);
        viewBinding.lvLista.setAdapter(adapter);

        List<Course> lista = db.createCourseDao().getAll();


        viewBinding.lvLista.setOnItemClickListener((adapterView, view, i, l) -> {

            String cursoNome = dataSet.get(i);

            for(Course course : lista){
                if(course.getName() == cursoNome){
                    db.createCourseDao().delete(course);
                }
            }

            dataSet.remove(i);
            adapter.notifyDataSetChanged();
        });

        for (Course course: lista){
            dataSet.add(course.getName());
        }
        adapter.notifyDataSetChanged();
    }

    private void createCourse(){
        Course course = new Course();
        course.setName("Backend");
        db.createCourseDao().create(course);
    }
}