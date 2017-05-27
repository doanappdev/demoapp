package com.app.demo.carsguide.dagger.component;

import android.content.Context;
import android.content.SharedPreferences;
import com.app.demo.carsguide.dagger.module.AppModule;
import com.app.demo.data.dagger.DataModule;
import com.google.gson.Gson;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

@Singleton
@Component(modules = {
    AppModule.class,
    DataModule.class})
public interface AppComponent {
  Gson getGson();
  Context getContext();
  SharedPreferences getSharedPreferences();
}
