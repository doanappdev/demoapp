package com.app.demo.data.repository;

import com.app.demo.data.model.Article;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public interface ArticleRepository {
  Observable<List<Article>> getArticles();
}
