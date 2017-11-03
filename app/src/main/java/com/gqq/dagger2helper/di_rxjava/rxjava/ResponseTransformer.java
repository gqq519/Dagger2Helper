package com.gqq.dagger2helper.di_rxjava.rxjava;

import com.gqq.dagger2helper.di_rxjava.ApiResponse;

import io.reactivex.functions.Function;

/**
 * Created by gqq on 17/11/2.
 */

public class ResponseTransformer<T> implements Function<ApiResponse<T>, T> {
    @Override
    public T apply(ApiResponse<T> apiResponse) throws Exception {
        if (apiResponse.error) {
            throw new RuntimeException();
        }
        return apiResponse.results;
    }
}
