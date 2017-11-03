package com.gqq.dagger2helper.di_rxjava.mvp.gank;

import com.gqq.dagger2helper.di_rxjava.gank.GankModel;
import com.gqq.dagger2helper.di_rxjava.mvp.MvpPresenter;
import com.gqq.dagger2helper.di_rxjava.mvp.MvpView;

import java.util.List;

/**
 * Created by gqq on 17/11/3.
 */

public interface GankContract {

    interface View extends MvpView {
        void gankLoaded(List<GankModel> data);
    }

    interface Presenter extends MvpPresenter<View> {
        void getGankData();
    }

}
