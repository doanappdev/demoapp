package com.app.demo.data.service.base;

import com.app.demo.data.service.BaseServiceFactory;
import com.google.gson.Gson;
import okhttp3.HttpUrl;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class ApiServiceFactory extends BaseServiceFactory {

  public static final HttpUrl BASE_URL = HttpUrl.parse("https://api.myjson.com/");
  public ApiServiceFactory(Gson gson) {
    super(gson);
  }

  @Override public <T> T create(Class<T> serviceType) {
    //String baseUrl = environmentRepository.getEnvironment().baseServiceUrl;
    return buildNetworkAdapter(BASE_URL, serviceType);
  }
}
