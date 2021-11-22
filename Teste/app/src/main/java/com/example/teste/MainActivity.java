package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mensagem = findViewById(R.id.tvText);

        Button botao = findViewById(R.id.btCount);
        botao.setOnClickListener(view -> {
            count += 1;
            mensagem.setText(String.valueOf(count));
        });
    }


    public void exibirMensagem(View view) {
        Toast.makeText(this, "Hello Toast!" + count, Toast.LENGTH_SHORT).show();
    }
}