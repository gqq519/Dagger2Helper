package com.gqq.dagger2helper;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;

import com.gqq.dagger2helper.di_google.DaggerCoffeeShop;
import com.gqq.dagger2helper.di_rxjava.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;


/**
 * Created by gqq on 17/11/1.
 */

public class DaggerApplication extends Application implements HasActivityInjector,HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        // 利用Dagger生成的实现类进行初始化
        DaggerCoffeeShop.builder().application(this).build().inject(this);
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
