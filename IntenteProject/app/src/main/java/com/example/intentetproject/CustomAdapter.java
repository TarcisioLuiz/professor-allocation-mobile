package com.example.intentetproject;

import android.content.ClipData;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentetproject.databinding.ItemListLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<String> data = new ArrayList<>();
    final static String KEY = "MESSAGE_KEY";

    public CustomAdapter(List<String> dataSet){
        this.data = dataSet;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemListLayoutBinding itemListLayoutBinding =
                ItemListLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ItemViewHolder(itemListLayoutBinding);   }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String valor = data.get(position);
        holder.bind(valor);
        holder.setIsRecyclable(false);
        holder.itemView.setOnLongClickListener(view -> {
            data.remove(data.get(position));
            notifyDataSetChanged();
            return true;
        });
        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), valor, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), Tela1Activity.class);
            intent.putExtra(KEY, valor);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
