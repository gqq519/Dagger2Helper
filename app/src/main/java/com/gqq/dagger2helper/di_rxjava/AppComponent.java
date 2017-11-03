package com.gqq.dagger2helper.di_rxjava;

import com.gqq.dagger2helper.ActivityBuildersModule;
import com.gqq.dagger2helper.DaggerApplication;
import com.gqq.dagger2helper.di_google.DripCoffeeModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by gqq on 17/11/1.
 */

@Singleton
@Component(modules = {
        ApiModule.class,
        DripCoffeeModule.class,
        AndroidInjectionModule.class,
        ActivityBuildersModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(DaggerApplication daggerApplication);
        AppComponent build();
    }
    void inject(DaggerApplication daggerApplication);

}
