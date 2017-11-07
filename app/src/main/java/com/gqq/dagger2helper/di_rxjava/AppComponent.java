package com.gqq.dagger2helper.di_rxjava;

import android.support.annotation.DrawableRes;

import com.gqq.dagger2helper.ActivityBuildersModule;
import com.gqq.dagger2helper.DaggerApplication;
import com.gqq.dagger2helper.di_google.DripCoffeeModule;
import com.gqq.dagger2helper.di_rxjava.gank.GankActivityModule;
import com.gqq.dagger2helper.di_rxjava.gank.GankRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by gqq on 17/11/1.
 */

/**
 * 1. modules
 *    a. AndroidInjectionModule：Dagger2提供，源码：
 *      Contains bindings to ensure the usability of {@code dagger.android} framework classes. This module should be installed in the component that is used to inject the {@link android.app.Application} class.
 *    b. ActivityBuildersModule：自定义，Activity使用Dagger注解，需要提供Activity的Builder
 *    c. GankRepositoryModule、ApiModule等提供需要的实例化类的依赖
 * 2. inject()：注解的初始化
 */
@Singleton
@Component(modules = {
        ApiModule.class,
        DripCoffeeModule.class,
        AndroidInjectionModule.class,
        ActivityBuildersModule.class,
        GankRepositoryModule.class
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
