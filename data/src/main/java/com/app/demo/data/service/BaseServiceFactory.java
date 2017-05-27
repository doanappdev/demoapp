package com.app.demo.data.service;

import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public abstract class BaseServiceFactory {
  protected Gson gson;

  public BaseServiceFactory(Gson gson) {
    this.gson = gson;
  }

  public abstract <T> T create(Class<T> serviceType);

  protected <T> T buildNetworkAdapter(HttpUrl baseUrl, Class<T> serviceType) {
    //OkHttpClient httpClient = getHttpClient();
    Retrofit retrofit = new Retrofit.Builder()
        //.client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .build();

    return retrofit.create(serviceType);
  }

  //
  //protected OkHttpClient getHttpClient() {
  //  OkHttpClient.Builder builder = new OkHttpClient.Builder()
  //      .addInterceptor(e -> e.proceed(e.request()));
  //  builder.addNetworkInterceptor(new HttpLoggingInterceptor()
  //      .setLevel(HttpLoggingInterceptor.Level.BODY));
  //  return builder.build();
  //}
}
