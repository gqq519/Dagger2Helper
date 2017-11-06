package com.gqq.dagger2helper.di_rxjava.rxjava;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gqq on 17/11/6.
 */

public class SchedulerHelper {
    public static <T> SingleTransformer<T, T> ioMain() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
