package com.app.demo.carsguide.dagger.component;

import android.content.Context;
import com.app.demo.carsguide.dagger.module.AppModule;
import com.app.demo.data.RxUtil;
import com.app.demo.data.dagger.DataModule;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public final class AppComponentBuilder {
  public static AppComponent build(Context context) {
    return DaggerAppComponent
        .builder()
        .appModule(new AppModule(context))
        .dataModule(new DataModule(new RxUtil(Schedulers.newThread(), AndroidSchedulers.mainThread())))
        .build();
    //return null;
  }
}
