package com.gqq.dagger2helper.di_rxjava.mvp.gank;

import com.gqq.dagger2helper.di_rxjava.gank.GankModel;
import com.gqq.dagger2helper.di_rxjava.gank.GankRepository;
import com.gqq.dagger2helper.di_rxjava.mvp.BasePresenter;
import com.gqq.dagger2helper.di_rxjava.rxjava.SchedulerHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by gqq on 17/11/3.
 */

public class GankPresenter extends BasePresenter<GankContract.View> implements GankContract.Presenter {

    private GankRepository gankRepository;

    @Inject
    public GankPresenter(GankRepository gankRepository) {
        this.gankRepository = gankRepository;
    }

    @Override
    public void getGankData() {
        checkViewAttached();
        getView().showLoading();
        addDisposable(gankRepository
                .getGankData()
                .compose(SchedulerHelper.ioMain())
                .subscribe(
                        gankModels -> {
                            getView().showContentView();
                            getView().gankLoaded(gankModels);
                        },
                        throwable ->
                                getView().showError(throwable, false)
                ));
    }
}
