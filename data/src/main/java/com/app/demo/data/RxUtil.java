package com.app.demo.data;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class RxUtil {

  Scheduler subscribeOnScheduler;
  Scheduler observeOnScheduler;

  public RxUtil() {
    this(Schedulers.io(), AndroidSchedulers.mainThread());
  }

  public RxUtil(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
    this.subscribeOnScheduler = subscribeOnScheduler;
    this.observeOnScheduler = observeOnScheduler;
  }

  public Scheduler getSubscribeOnScheduler() {
    return subscribeOnScheduler;
  }

  public Scheduler getObserveOnScheduler() {
    return observeOnScheduler;
  }


}
