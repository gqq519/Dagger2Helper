package com.gqq.dagger2helper.di_google;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gqq on 17/11/2.
 */

@Module
public class DripCoffeeModule {
    @Provides
    static Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    static Pump providePump() {
        return new Thermosiphon();
    }
}
