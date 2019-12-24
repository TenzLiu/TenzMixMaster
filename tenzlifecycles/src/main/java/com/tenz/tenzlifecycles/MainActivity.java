package com.tenz.tenzlifecycles;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.tenz.tenzlifecycles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getLifecycle().addObserver(new MyObserver());
        Log.e("tenz","activity:onCreate()--------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("tenz","activity:onStart()--------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tenz","activity:onResume()--------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("tenz","activity:onPause()--------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("tenz","activity:onRestart()--------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("tenz","activity:onStop()--------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tenz","MyObserver:onDestroy()--------");
    }

}
