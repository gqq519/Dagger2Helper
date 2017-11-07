package com.gqq.dagger2helper.di_rxjava;

import com.gqq.dagger2helper.BuildConfig;
import com.gqq.dagger2helper.di_rxjava.gank.GankService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gqq on 17/11/1.
 */

@Module
public class ApiModule {

    /**
     * okhttp 的初始化，单例
     * @return
     */
    @Singleton @Provides
    public static OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    /**
     * Retrofit的初始化，单例
     * @return
     */
    @Singleton @Provides
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    /**
     * 请求的初始化
     * @return
     */
    @Singleton @Provides
    public static GankService provideGankService(Retrofit retrofit) {
        return retrofit.create(GankService.class);
    }
}
