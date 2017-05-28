package com.app.demo.carsguide.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import butterknife.ButterKnife;
import com.app.demo.carsguide.CarsGuideApp;
import com.app.demo.carsguide.R;
import com.app.demo.carsguide.dagger.component.DaggerUiComponent;
import com.app.demo.carsguide.dagger.component.UiComponent;
import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity implements BaseView {

  @Inject protected SharedPreferences prefs;

  protected UiComponent component() {
    return DaggerUiComponent.builder()
        .appComponent(CarsGuideApp.of(this).component())
        .build();
    //return null;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    initToolbar(-1, false);
    ButterKnife.bind(this);
    super.onPostCreate(savedInstanceState);
  }

  @Override protected void onResume() {super.onResume();}

  @Override protected void onStop () {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  /** BaseView methods **/
  @Override public void hideKeyboard() {
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
  }

  @Override public void showProgressDialog(String message) {
  }

  @Override public void hideProgressDialog() {
  }

  /** Toolbar **/
  protected void initToolbar(int colorId, boolean isDisplayUpEnabled) {
    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    if(toolbar != null) setSupportActionBar(toolbar);
    //toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      if (colorId != -1 && colorId != Color.TRANSPARENT) {
        actionBar.setBackgroundDrawable(new ColorDrawable(colorId));
      }

      if (isDisplayUpEnabled) {
        actionBar.setDisplayHomeAsUpEnabled(true);
      }
    }
  }

  protected void setToolbarTitle(String title) {
    if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
  }

  protected void setToolbarIcon(int iconResource) {
    if(getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setHomeAsUpIndicator(iconResource);
    }
  }

  /**
   * Activity related methods
   */

  public static void launch(Activity fromActivity, Class<?> toActivity) {
    Intent intent = new Intent(fromActivity, toActivity);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
    ActivityCompat.startActivity(fromActivity, intent, null);
  }

  public static void launch(Activity fromActivity, Class<?> toActivity, Bundle args) {
    Intent intent = new Intent(fromActivity, toActivity);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
    intent.putExtras(args);
    ActivityCompat.startActivity(fromActivity, intent, null);
  }

  /**
   * Interface method used by sub view class to close out the activity
   */
  public void finishActivity() {finish();}

  protected void displaySnackBar(View view, String msg) {
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
  }
}


