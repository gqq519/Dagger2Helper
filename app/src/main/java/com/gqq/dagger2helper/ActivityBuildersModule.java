package com.gqq.dagger2helper;

import com.gqq.dagger2helper.di_google.DaggerActivity;
import com.gqq.dagger2helper.di_rxjava.Dagger2Activity;
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

    @ContributesAndroidInjector(modules = GankActivityModule.class)
    abstract Dagger2Activity contributeDagger2Activity();

}
