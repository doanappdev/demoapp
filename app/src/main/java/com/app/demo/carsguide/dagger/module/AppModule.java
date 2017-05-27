package com.app.demo.carsguide.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

@Module
public final class AppModule {
  private Context context;

  public AppModule(Context context) {
    this.context = context;
  }
  @Provides @Singleton SharedPreferences provideSharedPreferences() {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

  @Provides @Singleton Context provideContext() {
    return context;
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder().create();
  }

}
