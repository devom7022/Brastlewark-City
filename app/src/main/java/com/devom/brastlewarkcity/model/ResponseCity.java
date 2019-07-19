package com.devom.brastlewarkcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCity {
    @SerializedName("Brastlewark")
    @Expose
    List<Citizen> Brastlewark;

    public ResponseCity(List<Citizen> brastlewark) {
        Brastlewark = brastlewark;
    }

    public List<Citizen> getBrastlewark() {
        return Brastlewark;
    }

    public void setBrastlewark(List<Citizen> brastlewark) {
        Brastlewark = brastlewark;
    }
}
