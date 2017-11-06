package com.gqq.dagger2helper.di_rxjava.gank;

import com.gqq.dagger2helper.di_rxjava.rxjava.ResponseTransformer;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by gqq on 17/11/2.
 */

public class GankRepository {

    private GankService gankService;

    @Inject
    public GankRepository(GankService gankService) {
        this.gankService = gankService;
    }

    public Single<List<GankModel>> getGankData() {
        return gankService.getGankData()
                .map(new ResponseTransformer());
    }

}
