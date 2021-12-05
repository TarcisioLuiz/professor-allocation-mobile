package com.example.intentetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.intentetproject.databinding.ActivityViewBindingBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewBindingActivity extends AppCompatActivity {

    private ActivityViewBindingBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        List<String> palavras = new ArrayList<>();
        palavras.add("pipoca");
        palavras.add("Carro");
        palavras.add("Bicicleta");
        palavras.add("Arvore");
            palavras.add("Ventilador");

        CustomAdapter adapter = new CustomAdapter(palavras);
        viewBinding.rvLista.setAdapter(adapter);

    }

}