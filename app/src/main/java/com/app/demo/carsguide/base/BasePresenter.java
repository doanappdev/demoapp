package com.app.demo.carsguide.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public abstract class BasePresenter<V extends BaseView> {
  protected V view;
  protected CompositeDisposable composites = new CompositeDisposable();

  public void attachView(V view) {
    this.view = view;
  }

  /**
   * Check if view is attached to presenter.
   *
   * @return true | false depends if view is null or not
   */
  public boolean isViewAttached(){
    return this.view != null;
  }

  public void detachView() {
    this.view = null;
    composites.dispose();
  }

  public void addDisposable(Disposable disposable) {
    composites.add(disposable);
  }
}
