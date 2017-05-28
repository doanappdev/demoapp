package com.app.demo.carsguide.ui.article;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.app.demo.carsguide.R;
import com.app.demo.data.model.Article;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
  private Context context;
  private List<Article> articleList;

  public ArticleAdapter(Context context, List<Article> articleList) {
    this.context = context;
    this.articleList = articleList;
  }

  @Override public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ArticleViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.row_article, parent, false));
  }

  @Override public void onBindViewHolder(ArticleViewHolder holder, int position) {
    Article article = articleList.get(position);
    holder.bindData(article);
    holder.setTextView();
    holder.setIcon(context);
  }

  @Override public int getItemCount() {
    return articleList.size();
  }

  public void setArticleList(List<Article> articleList) {
    this.articleList = articleList;
  }
}
