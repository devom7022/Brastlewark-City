package com.devom.brastlewarkcity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devom.brastlewarkcity.R;
import com.devom.brastlewarkcity.adapterViewHolder.SimpleItemViewHolder;

import java.util.List;

public class SimpleItemAdapter extends RecyclerView.Adapter<SimpleItemViewHolder> {
    private List<String> items;
    View v;

    public SimpleItemAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SimpleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list_simple, parent, false);
        return new SimpleItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItemViewHolder holder, int pos) {
        final String localItem = items.get(pos);
        holder.bind(localItem);
    }

    @Override
    public int getItemCount() {
        return null != items ? items.size() : 0;
    }
}













