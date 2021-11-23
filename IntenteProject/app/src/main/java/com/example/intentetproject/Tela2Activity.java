package com.example.intentetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    final static String RESPONSE_KEY = "response_key";
    final static int RESULT_CODE_SUCCESS = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        EditText editText = findViewById(R.id.edResponse);
        Button button =findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent mensageiro = new Intent(this, Tela1Activity.class);
            mensageiro.putExtra(RESPONSE_KEY, editText.getText().toString());
            setResult(RESULT_CODE_SUCCESS, mensageiro);
            finish();
        });

        String mensagem = getIntent().getStringExtra(Tela1Activity.KEY);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(mensagem);
    }
}