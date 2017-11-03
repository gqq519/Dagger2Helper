package com.gqq.dagger2helper.di_rxjava.mvp;

/**
 * Created by gqq on 17/11/3.
 */

public interface MvpView {
    void showLoading();
    void showEmptyView();
    void showError(Throwable throwable, boolean isShowErrorPage);
    void showContentView();

}
