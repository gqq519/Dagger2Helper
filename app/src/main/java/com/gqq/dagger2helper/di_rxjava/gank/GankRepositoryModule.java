package com.gqq.dagger2helper.di_rxjava.gank;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gqq on 17/11/6.
 */

@Module
public class GankRepositoryModule {

    @Singleton @Provides
    public GankRepository provideGankRepository(GankService gankService) {
        return new GankRepository(gankService);
    }

}
