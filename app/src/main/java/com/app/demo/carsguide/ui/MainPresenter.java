package com.app.demo.carsguide.ui;

import android.util.Log;
import com.app.demo.carsguide.base.BasePresenter;
import com.app.demo.carsguide.interactor.ArticleInteractor;
import com.app.demo.data.model.Article;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class MainPresenter extends BasePresenter<MainPresenterView> {
  private static final String TAG = MainPresenter.class.getSimpleName();

  private ArticleInteractor articleInteractor;

  //private List<Article> articles;

  @Inject public MainPresenter(ArticleInteractor articleInteractor) {
    this.articleInteractor = articleInteractor;
  }

  public void getArticles() {
    articleInteractor
        .getArticles()
        .subscribe(results -> view.displayArticles(results));
    //printArticles();
  }

  public void refreshArticles() {
    getArticles();
  }


  //private void printArticles() {
  //  for (Article a : articles) {
  //    Log.d(TAG, "----------------------------");
  //    Log.d(TAG, "title : " + a.getTitle());
  //    Log.d(TAG, "abstract : " + a.getAbstract());
  //    Log.d(TAG, "image_url : " + a.getImageUrl());
  //  }
  //}



}
