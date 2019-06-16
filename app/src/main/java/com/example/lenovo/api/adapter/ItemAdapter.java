package com.example.lenovo.api.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lenovo.api.R;
import com.example.lenovo.api.databinding.ItemUserBinding;
import com.example.lenovo.api.model.Name;
import com.example.lenovo.api.model.Result;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Result> results;

    public ItemAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_user, viewGroup,
                false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        itemViewHolder.bind(results.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

//    public void add(Name name){
//        results.add(name);
//        notifyItemInserted(users.size()-1);
//    }
}
