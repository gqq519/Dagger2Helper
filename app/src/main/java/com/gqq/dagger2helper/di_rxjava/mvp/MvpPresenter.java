package com.gqq.dagger2helper.di_rxjava.mvp;

/**
 * Created by gqq on 17/11/3.
 */

public interface MvpPresenter<V extends MvpView> {
    void attachView(V mvpView);
    void detachView();
}
