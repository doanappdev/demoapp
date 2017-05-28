package com.app.demo.carsguide.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
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

  @BindView(R.id.main_container) CoordinatorLayout coordinatorLayout;
  @BindView(R.id.swipe_to_refresh) SwipeRefreshLayout swipeRefreshLayout;
  @BindView(R.id.article_rv) RecyclerView articlesRv;
  @BindColor(R.color.colorPrimary) int primaryColour;
  @Inject MainPresenter presenter;

  private ArticleAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);
    Log.d(TAG, "onCreate() called!");
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    presenter.attachView(this);
    initToolbar(primaryColour, false);
    swipeRefreshLayout.setOnRefreshListener(refreshListener);

    //add a handler to fake a slow network response, for testing purpose.
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override public void run() {
        presenter.getArticles();
      }
    },2000);
  }

  @Override public void displayArticles(List<Article> articles) {
    if (swipeRefreshLayout.isRefreshing()) {
      onRefresh(articles);
    } else {
      initAdapter(articles);
    }
  }

  @Override public void displayError(String errorMessage) {
    displaySnackBar(coordinatorLayout, errorMessage);
    if (swipeRefreshLayout.isRefreshing()) {
      swipeRefreshLayout.setRefreshing(false);
    }
  }

  private void initAdapter(List<Article> articles) {
    adapter = new ArticleAdapter(this, articles);
    articlesRv.setLayoutManager(new LinearLayoutManager(this));
    articlesRv.setAdapter(adapter);
    displaySnackBar(coordinatorLayout, "Download completed");
  }

  private void onRefresh(List<Article> articles) {
    swipeRefreshLayout.setRefreshing(false);
    if (adapter != null) {
      adapter.setArticleList(articles);
      adapter.notifyDataSetChanged();
    } else {
      initAdapter(articles);
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

  private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
    @Override public void onRefresh() {
      presenter.refreshArticles();
    }
  };
}
