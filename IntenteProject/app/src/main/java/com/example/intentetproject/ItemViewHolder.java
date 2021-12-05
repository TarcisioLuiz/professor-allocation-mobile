package com.example.intentetproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentetproject.databinding.ItemListLayoutBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private ItemListLayoutBinding binding;

    public ItemViewHolder(ItemListLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String valor){
        binding.tvNameItem.setText(valor);
        if(getLayoutPosition() == 0){
            binding.ivImage.setImageResource(R.drawable.tanjiro);
        }

    }
}
