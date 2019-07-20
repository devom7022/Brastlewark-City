package com.devom.brastlewarkcity.adapterViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devom.brastlewarkcity.R;

public class SimpleItemViewHolder extends RecyclerView.ViewHolder {
    private TextView tvItemSimple;

    public SimpleItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tvItemSimple = itemView.findViewById(R.id.tv_item_simple);
    }

    public void bind(String value) {
        tvItemSimple.setText(value.trim());
    }
}