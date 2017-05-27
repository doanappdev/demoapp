package com.app.demo.data.dagger;

import com.app.demo.data.RxUtil;
import dagger.Module;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */
@Module
public class DataModule {

  protected RxUtil rxUtil;

  public DataModule(RxUtil rxUtil) {
    this.rxUtil = rxUtil;
  }
}
