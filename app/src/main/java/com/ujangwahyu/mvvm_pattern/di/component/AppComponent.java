package com.ujangwahyu.mvvm_pattern.di.component;

import android.app.Application;

import com.ujangwahyu.mvvm_pattern.BaseApplication;
import com.ujangwahyu.mvvm_pattern.di.modules.ActivityBindingModule;
import com.ujangwahyu.mvvm_pattern.di.modules.ContextModule;
import com.ujangwahyu.mvvm_pattern.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

@Singleton
@Component(modules = {ContextModule.class, NetworkModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication>{

    void inject(BaseApplication app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
