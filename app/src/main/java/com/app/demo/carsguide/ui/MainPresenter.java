package com.app.demo.carsguide.ui;

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
            results -> view.displayArticles(results),
            error -> view.displayError("Network error, please try again!"));
  }

  public void refreshArticles() {
    getArticles();
  }
}
