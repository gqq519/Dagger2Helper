package com.gqq.dagger2helper.di_google;

import com.gqq.dagger2helper.DaggerApplication;
import com.gqq.dagger2helper.ActivityBuildersModule;
import com.gqq.dagger2helper.di_rxjava.ApiModule;
import com.gqq.dagger2helper.di_rxjava.gank.GankActivityModule;
import com.gqq.dagger2helper.di_rxjava.gank.GankRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by gqq on 17/11/2.
 */

@Singleton
@Component(modules = {
        ApiModule.class,
        DripCoffeeModule.class,
        AndroidInjectionModule.class,
        ActivityBuildersModule.class,
        GankRepositoryModule.class
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

