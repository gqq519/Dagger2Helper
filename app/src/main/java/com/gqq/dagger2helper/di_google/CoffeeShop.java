package com.gqq.dagger2helper.di_google;

import com.gqq.dagger2helper.DaggerApplication;
import com.gqq.dagger2helper.ActivityBuildersModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by gqq on 17/11/2.
 */

@Singleton
@Component(modules = {
        DripCoffeeModule.class,
        AndroidInjectionModule.class,
        ActivityBuildersModule.class
})
public interface CoffeeShop {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(DaggerApplication application);
        CoffeeShop build();
    }
    void inject(DaggerApplication application);
}

