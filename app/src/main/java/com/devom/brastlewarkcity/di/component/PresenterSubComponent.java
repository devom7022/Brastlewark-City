package com.devom.brastlewarkcity.di.component;

import com.devom.brastlewarkcity.di.module.AdapterModule;
import com.devom.brastlewarkcity.di.module.PresenterModule;
import com.devom.brastlewarkcity.di.scope.SessionScope;
import com.devom.brastlewarkcity.ui.citizens.CitizensActivity;

import dagger.Subcomponent;

@SessionScope
@Subcomponent(modules = {PresenterModule.class, AdapterModule.class})
public interface PresenterSubComponent {
    void inject(CitizensActivity citizensActivity);
}
