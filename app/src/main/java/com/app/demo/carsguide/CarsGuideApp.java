package com.app.demo.carsguide;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.app.demo.carsguide.dagger.component.AppComponent;
import com.app.demo.carsguide.dagger.component.AppComponentBuilder;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class CarsGuideApp extends Application {

  AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = component();
  }

  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

  public AppComponent component() {
    if (appComponent == null) buildComponent(this);
    return appComponent;
  }

  public static CarsGuideApp of(Context context) {
    return (CarsGuideApp) context.getApplicationContext();
  }

  public void buildComponent(Context context) {
    appComponent = AppComponentBuilder.build(context.getApplicationContext());
  }
}
