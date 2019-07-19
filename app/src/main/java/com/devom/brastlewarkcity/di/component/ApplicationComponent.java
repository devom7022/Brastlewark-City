package com.devom.brastlewarkcity.di.component;

import com.devom.brastlewarkcity.di.module.ApplicationContextModule;
import com.devom.brastlewarkcity.di.module.PresenterModule;
import com.devom.brastlewarkcity.di.module.RetrofitModule;
import com.devom.brastlewarkcity.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    PresenterSubComponent plusPresenterSubComponent(PresenterModule presenterModule);
}
