package com.devom.brastlewarkcity.ui.citizens;

import com.devom.brastlewarkcity.model.Citizen;

import java.util.List;

public interface CitizensView {

    void showProgress();

    void hideProgress();

    void setItemsOnAdapters(List<Citizen> citizens);

    void onFailure(String error);
}
