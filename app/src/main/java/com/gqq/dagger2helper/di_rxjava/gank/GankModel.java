package com.gqq.dagger2helper.di_rxjava.gank;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gqq on 17/11/2.
 */

public class GankModel {

    /**
     * _id : 59f8553f421aa90fef2034e9
     * createdAt : 2017-10-31T18:49:35.980Z
     * desc : 深度学习js与安卓的交互以及WebView的那些坑
     * images : ["http://img.gank.io/d1d4f7b4-9291-499a-8b20-c3c485c46119"]
     * publishedAt : 2017-11-01T14:20:59.209Z
     * source : web
     * type : Android
     * url : http://www.jianshu.com/p/b9164500d3fb
     * used : true
     * who : 阿韦
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("desc")
    private String desc;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("source")
    private String source;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("used")
    private boolean used;
    @SerializedName("who")
    private String owner;
    @SerializedName("images")
    private List<String> images;

    @Override
    public String toString() {
        return desc;
    }
}
