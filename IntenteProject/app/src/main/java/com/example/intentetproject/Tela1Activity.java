package com.example.intentetproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1Activity extends AppCompatActivity {

    final static String KEY = "Key_message";
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mensagem = findViewById(R.id.edMenssagem);
        textView2 = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent carteiro = new Intent(this, Tela2Activity.class);
            carteiro.putExtra(KEY, mensagem.getText().toString());
//            startActivity(carteiro);
            startActivityForResult(carteiro, 123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123) {
            if(resultCode == Tela2Activity.RESULT_CODE_SUCCESS){

                String valor = data.getStringExtra(Tela2Activity.RESPONSE_KEY);
                textView2.setText(valor);
            }
        }
    }
}