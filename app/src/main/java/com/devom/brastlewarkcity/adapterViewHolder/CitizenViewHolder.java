package com.devom.brastlewarkcity.adapterViewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.devom.brastlewarkcity.R;
import com.devom.brastlewarkcity.model.Citizen;

public class CitizenViewHolder extends RecyclerView.ViewHolder {
    private RequestManager requestManager;
    private CardView itemCitizen;
    private ImageView ivThumbnail;
    private TextView tvName;

    public CitizenViewHolder(@NonNull View itemView, RequestManager requestManager) {
        super(itemView);
        this.requestManager = requestManager;
        ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
        itemCitizen = itemView.findViewById(R.id.item_citizen);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    public void bind(Citizen citizen, int side) {
        String url = citizen.getThumbnail();
        requestManager
                .load(url)
                .centerCrop()
                .into(ivThumbnail);
        tvName.setText(citizen.getName());

        ViewGroup.LayoutParams paramsItem = itemCitizen.getLayoutParams();
        paramsItem.height = side;

        ViewGroup.LayoutParams paramsName = tvName.getLayoutParams();
        paramsName.height = side / 3;

    }
}
