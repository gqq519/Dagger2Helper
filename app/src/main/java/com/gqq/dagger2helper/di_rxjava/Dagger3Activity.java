package com.gqq.dagger2helper.di_rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gqq.dagger2helper.R;
import com.gqq.dagger2helper.di_rxjava.gank.GankModel;
import com.gqq.dagger2helper.di_rxjava.mvp.gank.GankContract;
import com.gqq.dagger2helper.di_rxjava.mvp.gank.GankPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class Dagger3Activity extends BaseActivity implements GankContract.View {

    @Inject
    GankPresenter presenter;

    @BindView(R.id.btn_load)
    Button btnLoad;
    @BindView(R.id.listview)
    ListView listView;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        presenter.attachView(this);
    }

    @OnClick(R.id.btn_load)
    void onViewClicked() {
        presenter.getGankData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dagger2;
    }

    @Override
    public void showLoading() {
        btnLoad.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError(Throwable throwable, boolean isShowErrorPage) {
        Toast.makeText(this, "error:" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContentView() {
        btnLoad.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    @Override
    public void gankLoaded(List<GankModel> data) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));
    }
}
