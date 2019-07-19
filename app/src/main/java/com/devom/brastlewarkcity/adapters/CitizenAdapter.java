package com.devom.brastlewarkcity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devom.brastlewarkcity.R;
import com.devom.brastlewarkcity.adapterViewHolder.CitizenViewHolder;
import com.devom.brastlewarkcity.model.Citizen;

import java.util.ArrayList;
import java.util.List;

public class CitizenAdapter extends RecyclerView.Adapter<CitizenViewHolder> {

    private int side;
    private RequestManager requestManager;
    private List<Citizen> citizenList = new ArrayList<>();
    private CitizenAdapterView view;

    public CitizenAdapter(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public CitizenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_citizen, parent, false);
        return new CitizenViewHolder(view, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull CitizenViewHolder holder, int pos) {
        final Citizen localItem = citizenList.get(pos);

        holder.bind(localItem, getSide());

        holder.itemView.setOnClickListener(v -> {
            view.setItemOnClick(localItem);
        });

    }

    @Override
    public int getItemCount() {
        return null != citizenList ? citizenList.size() : 0;
    }

    public void setView(CitizenAdapterView view, int sideX, int colums) {
        this.view = view;
        this.side = sideX / colums;
    }

    private int getSide() {
        return this.side;
    }

    public void setData(List<Citizen> citizenList) {
        this.citizenList.clear();
        this.citizenList.addAll(citizenList);
        notifyDataSetChanged();
    }

}













