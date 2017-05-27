package com.app.demo.carsguide.dagger.component;

import com.app.demo.carsguide.dagger.PerActivity;
import com.app.demo.carsguide.ui.MainActivity;
import dagger.Component;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class)
public interface UiComponent {
  void inject(MainActivity activity);
}
