package com.gqq.dagger2helper.di_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class Dagger2Activity extends AppCompatActivity implements GankContract.View {

    @Inject
    GankPresenter presenter;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.btn_load)
    Button btnLoad;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);

        AndroidInjection.inject(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
        btnLoad.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError(Throwable throwable, boolean isShowErrorPage) {
        Toast.makeText(this, "error:"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContentView() {
        progress.setVisibility(View.GONE);
        btnLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void gankLoaded(List<GankModel> data) {
        listview.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data));
    }

    @OnClick(R.id.btn_load)
    public void onViewClicked() {
        presenter.getGankData();
    }
}
