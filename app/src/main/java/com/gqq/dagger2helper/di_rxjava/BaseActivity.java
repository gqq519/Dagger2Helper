package com.gqq.dagger2helper.di_rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * Created by gqq on 17/11/6.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
    }

    /**
     * 如果整体使用Fragment，也可以用Fragment的onAttach和onDetach
     */
    @Override
    public void onAttachedToWindow() {
        AndroidInjection.inject(this);
        super.onAttachedToWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected abstract int getLayoutId();
}
