package com.app.demo.data.dagger;

import com.app.demo.data.RxUtil;
import com.app.demo.data.service.api.ArticleService;
import com.app.demo.data.service.base.ApiServiceFactory;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */
@Module
public class DataModule {

  protected RxUtil rxUtil;

  public DataModule(RxUtil rxUtil) {
    this.rxUtil = rxUtil;
  }

  @Provides @Singleton ApiServiceFactory provideApiServiceFactory(Gson gson) {
    return new ApiServiceFactory(gson);
  }

  @Provides @Singleton ArticleService provideArticleService(ApiServiceFactory serviceFactory) {
    return serviceFactory.create(ArticleService.class);
  }

  @Provides @Singleton RxUtil provideRxUtil() {
    return rxUtil;
  }

}
