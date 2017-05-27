package com.app.demo.carsguide.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindColor;
import butterknife.BindView;
import com.app.demo.carsguide.R;
import com.app.demo.carsguide.base.BaseActivity;
import com.app.demo.carsguide.ui.article.ArticleAdapter;
import com.app.demo.data.model.Article;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenterView {

  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.article_rv) RecyclerView articlesRv;
  @BindColor(R.color.colorPrimary) int primaryColour;
  @Inject MainPresenter presenter;

  private ArticleAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    initToolbar(primaryColour, false);
    presenter.attachView(this);
    presenter.getArticles();
  }

  @Override public void displayArticles(List<Article> articles) {
    initAdapter(articles);
  }

  private void initAdapter(List<Article> articles) {
    if (adapter == null) {
      adapter = new ArticleAdapter(this, articles);
      articlesRv.setLayoutManager(new LinearLayoutManager(this));
      articlesRv.setAdapter(adapter);
    }
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Log.d(TAG, "onConfiguration Changed called!");

  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }
}
