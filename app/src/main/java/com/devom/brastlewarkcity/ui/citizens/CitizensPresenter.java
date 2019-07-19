package com.devom.brastlewarkcity.ui.citizens;

import com.devom.brastlewarkcity.model.Citizen;

import java.util.List;

public class CitizensPresenter implements CitizensInteractor.OnFinishedListener {

    private CitizensView view;
    private CitizensInteractor interactor;

    public CitizensPresenter(CitizensInteractor interactor) {
        this.interactor = interactor;
    }

    void setView(CitizensView view) {
        this.view = view;
    }

    void onDestroy() {
        view = null;
    }

    void getCityData() {
        if (view != null) {
            view.showProgress();
        }
        interactor.getDataGnomes(this);
    }

    void setNameToFilter(String queryName) {
        interactor.filtetForName(queryName, this);
    }

    @Override
    public void onSuccess(List<Citizen> responseCity) {
        if (view != null) {
            view.setItemsOnAdapters(responseCity);
            view.hideProgress();
        }
    }

    @Override
    public void onFailure(String error) {
        if (view != null) {
            view.hideProgress();
            view.onFailure(error);
        }
    }

}
