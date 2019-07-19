package com.devom.brastlewarkcity.api;

import com.devom.brastlewarkcity.model.ResponseCity;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.devom.brastlewarkcity.api.ApiConstants.DATA_GNOMES;

public interface ApiClient {
    @GET(DATA_GNOMES)
    Call<ResponseCity> getDataGnomes();
}