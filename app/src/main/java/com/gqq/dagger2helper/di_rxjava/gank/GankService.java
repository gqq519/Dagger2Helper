package com.gqq.dagger2helper.di_rxjava.gank;

import com.gqq.dagger2helper.di_rxjava.ApiResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by gqq on 17/11/2.
 */

public interface GankService {

    @GET("/data/Android/10/1")
    Single<ApiResponse<List<GankModel>>> getGankData();

}
