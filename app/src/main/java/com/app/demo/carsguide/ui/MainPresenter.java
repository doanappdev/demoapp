package com.app.demo.carsguide.ui;

import android.util.Log;
import com.app.demo.carsguide.base.BasePresenter;
import com.app.demo.carsguide.interactor.ArticleInteractor;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class MainPresenter extends BasePresenter<MainPresenterView> {
  private static final String TAG = MainPresenter.class.getSimpleName();

  private ArticleInteractor articleInteractor;

  @Inject public MainPresenter(ArticleInteractor articleInteractor) {
    this.articleInteractor = articleInteractor;
  }

  public void getArticles() {
    articleInteractor
        .getArticles()
        .subscribe(
            results -> {
              if (isViewAttached()) {
                view.displayArticles(results);
                view.hideProgressDialog();
              } else {
                Log.e(TAG, "view is not attached!!");
              }
            },
            error -> {
              view.displayError("Network error, please swipe to refresh!");
              view.hideProgressDialog();
            });
  }

  public void refreshArticles() {
    getArticles();
  }
}
