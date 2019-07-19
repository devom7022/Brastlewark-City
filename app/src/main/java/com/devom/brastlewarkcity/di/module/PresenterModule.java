package com.devom.brastlewarkcity.di.module;

import com.devom.brastlewarkcity.api.ApiClient;
import com.devom.brastlewarkcity.di.scope.SessionScope;
import com.devom.brastlewarkcity.ui.citizens.CitizensInteractor;
import com.devom.brastlewarkcity.ui.citizens.CitizensPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @SessionScope
    CitizensInteractor providerCitizenInteractor(ApiClient apiClient) {
        return new CitizensInteractor(apiClient);
    }

    @Provides
    @SessionScope
    CitizensPresenter providesPresenterCitizen(CitizensInteractor interactor) {
        return new CitizensPresenter(interactor);
    }
}
