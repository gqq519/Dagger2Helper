package com.gqq.dagger2helper.di_google;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by gqq on 17/11/2.
 */

class Thermosiphon implements Pump {

    @Override
    public void pump() {
        Log.i("TAG", "=> => pumping => =>");
    }
}
