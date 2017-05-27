package com.app.demo.data.repository;

import com.app.demo.data.RxUtil;
import com.app.demo.data.model.Article;
import com.app.demo.data.service.api.ArticleService;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class ArticleRepositoryImpl implements ArticleRepository {

  private ArticleService articleService;
  private RxUtil rxUtil;

  public ArticleRepositoryImpl(ArticleService articleService, RxUtil rxUtil) {
    this.articleService = articleService;
    this.rxUtil = rxUtil;
  }

  @Override public Observable<List<Article>> getArticles() {
    return articleService
        .getArticle()
        .subscribeOn(rxUtil.getSubscribeOnScheduler())
        .observeOn(rxUtil.getObserveOnScheduler());
  }
}
