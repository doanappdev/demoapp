package com.app.demo.carsguide.ui.article;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.demo.carsguide.R;
import com.app.demo.data.model.Article;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
  @BindView(R.id.icon_iv) ImageView iconIv;
  @BindView(R.id.title_tv) TextView titleTv;
  @BindView(R.id.abstract_tv) TextView abstractTv;

  private Article article;
  private ArticleAdapter.OnArticleClickListener listener;

  public ArticleViewHolder(View view) {
    super(view);
    ButterKnife.bind(this, view);
  }

  public void bindData(Article article) {
    this.article = article;
  }

  public void setListener(ArticleAdapter.OnArticleClickListener listener) {
    this.listener = listener;
  }

  public void setIcon(Context context) {
    Glide.with(context)
        .load(article.getImageUrl())
        .listener(new RequestListener<String, GlideDrawable>() {
          @Override
          public boolean onException(Exception e, String model, Target<GlideDrawable> target,
              boolean isFirstResource) {
            iconIv.setVisibility(View.GONE);
            return false;
          }

          @Override public boolean onResourceReady(GlideDrawable resource, String model,
              Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            iconIv.setVisibility(View.VISIBLE);
            return false;
          }
        })
        .into(iconIv);
  }

  public void setTextView() {
    titleTv.setText(article.getTitle());
    abstractTv.setText(article.getAbstract());
  }

  @OnClick(R.id.card_view) void onArticleClick() {
    listener.onArticleClickListener(article.getUrl());
  }
}
