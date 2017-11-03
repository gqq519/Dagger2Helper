package com.gqq.dagger2helper.di_rxjava;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gqq on 17/11/2.
 */

public class ApiResponse<T> {
    @SerializedName("error")
    public boolean error;
    @SerializedName("results")
    public T results;
}
