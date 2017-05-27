package com.app.demo.carsguide.interactor;

import com.app.demo.data.model.Article;
import com.app.demo.data.repository.ArticleRepository;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class ArticleInteractor {
  ArticleRepository articleRepository;

  public ArticleInteractor(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public Observable<List<Article>> getArticles() {
    return articleRepository.getArticles();
  }
}
