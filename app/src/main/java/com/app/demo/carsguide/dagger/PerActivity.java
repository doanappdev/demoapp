package com.app.demo.carsguide.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 * Annotation which specifies a 'Scope'.
 * The scope we are creating is the life time of the activity
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
