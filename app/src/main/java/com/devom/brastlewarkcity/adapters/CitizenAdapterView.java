package com.devom.brastlewarkcity.adapters;

import android.widget.ImageView;

import com.devom.brastlewarkcity.model.Citizen;

public interface CitizenAdapterView {
    void setItemOnClick(Citizen citizen, ImageView ivThumbnail);
}
