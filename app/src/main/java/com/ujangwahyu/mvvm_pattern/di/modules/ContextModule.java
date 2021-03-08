package com.ujangwahyu.mvvm_pattern.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

@Module
public abstract class ContextModule {

    private final Context context;
    public ContextModule(Context context) {
        this.context = context;
    }

    @Binds
    abstract Context bindContext(Application application);
}
