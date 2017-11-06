package com.gqq.dagger2helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gqq.dagger2helper.di_google.DaggerActivity;
import com.gqq.dagger2helper.di_rxjava.Dagger2Activity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.BindsInstance;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.main_list)
    ListView listView;

    private Demo[] demos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        demos = createDemos();
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,demos));
        listView.setOnItemClickListener(this);
    }

    private Demo[] createDemos() {
        return new Demo[]{
                new Demo("Dagger的官方Demo", new Intent(this,DaggerActivity.class)),
                new Demo("Dagger的实践",new Intent(this, Dagger2Activity.class))
        };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(demos[position].intent);
    }

    static class Demo {
        String name;
        Intent intent;

        public Demo(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
