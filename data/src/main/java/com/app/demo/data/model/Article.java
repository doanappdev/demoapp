package com.app.demo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class Article {
  @SerializedName("title") private String title;
  @SerializedName("abstract") private String description;
  @SerializedName("image_url") private String imageUrl;
  @SerializedName("url") private String url;

  public String getTitle() {return title;}
  public String getAbstract() {return description;}
  public String getImageUrl() {return imageUrl;}
  public String getUrl() {return url;}
}
