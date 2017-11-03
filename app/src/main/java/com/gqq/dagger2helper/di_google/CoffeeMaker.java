package com.gqq.dagger2helper.di_google;

import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by gqq on 17/11/2.
 */

class CoffeeMaker {
    private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.
    private final Pump pump;

    @Inject
    CoffeeMaker(Lazy<Heater> heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.get().on();
        pump.pump();
        Log.i("TAG", " [_]P coffee! [_]P ");
        heater.get().off();
    }
}
