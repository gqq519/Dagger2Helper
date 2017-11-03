package com.gqq.dagger2helper.di_google;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gqq.dagger2helper.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class DaggerActivity extends AppCompatActivity{

    @Inject
    Pump pump;

    @Inject
    CoffeeMaker coffeeMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        // 在 activity或fragment等中使用注解，需要在application实现HasActivityInjector等相应接口,并且调用该方法
        AndroidInjection.inject(this);

//        pump.pump();

        coffeeMaker.brew();
    }
}
