package com.devom.brastlewarkcity.ui.citizens;

import com.devom.brastlewarkcity.api.ApiClient;
import com.devom.brastlewarkcity.app.BaseApplication;
import com.devom.brastlewarkcity.model.Citizen;
import com.devom.brastlewarkcity.model.ResponseCity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CitizensInteractor {
    private static String TAG = CitizensInteractor.class.getSimpleName();
    private ApiClient apiClient;
    private ResponseCity dataResponse;

    interface OnFinishedListener {
        void onFailure(String error);

        void onSuccess(List<Citizen> responseCity);
    }

    public CitizensInteractor(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    void filtetForName(String queryName, OnFinishedListener listener) {
        if (queryName.equals("")) {
            listener.onSuccess(dataResponse.getBrastlewark());
            return;
        }

        List<Citizen> filteredCitizen = new ArrayList<>();

        for (Citizen citizen : dataResponse.getBrastlewark()) {
            if (citizen.getName().toLowerCase().contains(queryName.toLowerCase())) {
                filteredCitizen.add(citizen);
            }
        }

        if (filteredCitizen.size() > 0) {
            listener.onSuccess(filteredCitizen);
        } else {
            listener.onFailure("No hay ningún ciudadano con ese nombre");
        }
    }

    void getDataGnomes(final OnFinishedListener listener) {
        if (!BaseApplication.getConnectionToNetwork()) {
            listener.onFailure("Revise su conexión a internet");
        }
        Call<ResponseCity> call = apiClient.getDataGnomes();
        call.enqueue(new Callback<ResponseCity>() {
            @Override
            public void onResponse(Call<ResponseCity> call, Response<ResponseCity> response) {
                if (response.isSuccessful()) {
                    dataResponse = response.body();
                    if (dataResponse != null) {
                        listener.onSuccess(dataResponse.getBrastlewark());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseCity> call, Throwable t) {
                listener.onFailure("Intente más tarde");
            }
        });
    }
}
