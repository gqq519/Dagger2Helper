package com.gqq.dagger2helper.di_google;

import android.util.Log;

/**
 * Created by gqq on 17/11/2.
 */

class ElectricHeater implements Heater {
    boolean heating;

    @Override public void on() {
        Log.i("TAG","~ ~ ~ heating ~ ~ ~");
        this.heating = true;
    }

    @Override public void off() {
        this.heating = false;
    }

    @Override public boolean isHot() {
        return heating;
    }
}

