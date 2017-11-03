package com.gqq.dagger2helper.di_rxjava.mvp.gank;

import com.gqq.dagger2helper.di_rxjava.gank.GankRepository;
import com.gqq.dagger2helper.di_rxjava.mvp.BasePresenter;

/**
 * Created by gqq on 17/11/3.
 */

public class GankPresenter extends BasePresenter<GankContract.View> implements GankContract.Presenter {

    private GankRepository gankRepository;

    public GankPresenter(GankRepository gankRepository) {
        this.gankRepository = gankRepository;
    }

    @Override
    public void getGankData() {
        checkViewAttached();
        getView().showLoading();
    }
}
