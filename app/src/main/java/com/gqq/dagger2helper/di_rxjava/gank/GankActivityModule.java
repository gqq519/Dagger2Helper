package com.gqq.dagger2helper.di_rxjava.gank;

import com.gqq.dagger2helper.di_rxjava.mvp.gank.GankPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gqq on 17/11/6.
 */

@Module
public class GankActivityModule {

    @Provides
    public static GankPresenter provideGankPresenter(GankRepository gankRepository) {
        return new GankPresenter(gankRepository);
    }


}
