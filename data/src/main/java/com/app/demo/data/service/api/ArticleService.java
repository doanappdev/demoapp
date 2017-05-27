package com.app.demo.data.service.api;

import com.app.demo.data.model.Article;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public interface ArticleService {

  @GET("bins/51mx1")
  Observable<List<Article>> getArticle();
}
