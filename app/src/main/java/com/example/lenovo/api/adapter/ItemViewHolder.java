package com.example.lenovo.api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.api.databinding.ItemUserBinding;
import com.example.lenovo.api.model.Name;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ItemUserBinding binding;

    public ItemViewHolder(@NonNull ItemUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Name name){
        binding.setName(name);
    }
}
