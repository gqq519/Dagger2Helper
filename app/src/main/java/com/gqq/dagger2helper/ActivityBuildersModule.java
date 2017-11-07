package com.gqq.dagger2helper;

import com.gqq.dagger2helper.di_google.DaggerActivity;
import com.gqq.dagger2helper.di_rxjava.Dagger2Activity;
import com.gqq.dagger2helper.di_rxjava.Dagger3Activity;
import com.gqq.dagger2helper.di_rxjava.gank.GankActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gqq on 17/11/2.
 */

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract DaggerActivity contributeDaggerActivity();

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    // 只针对于某一个页面需要的依赖，可以单独在参数中添加，无需添加到AppComponent
    @ContributesAndroidInjector(modules = GankActivityModule.class)
    abstract Dagger2Activity contributeDagger2Activity();

    @ContributesAndroidInjector(modules = GankActivityModule.class)
    abstract Dagger3Activity contributeDagger3Activity();

}
