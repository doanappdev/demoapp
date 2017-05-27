package com.app.demo.carsguide.ui;

import com.app.demo.carsguide.base.BasePresenter;
import com.app.demo.carsguide.base.BaseView;
import com.app.demo.data.model.Article;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public interface MainPresenterView extends BaseView {
  void displayArticles(List<Article> articles);
}
