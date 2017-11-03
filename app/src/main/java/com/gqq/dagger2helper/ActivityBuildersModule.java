package com.gqq.dagger2helper;

import com.gqq.dagger2helper.MainActivity;
import com.gqq.dagger2helper.di_google.DaggerActivity;

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

}
