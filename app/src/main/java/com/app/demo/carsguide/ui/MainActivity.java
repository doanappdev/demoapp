package com.app.demo.carsguide.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.app.demo.carsguide.R;
import com.app.demo.carsguide.base.BaseActivity;

public class MainActivity extends BaseActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Log.d(TAG, "onConfiguration Changed called!");

  }
}
