package com.ujangwahyu.mvvm_pattern.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ujangwahyu.mvvm_pattern.di.ViewModelFactory;
import com.ujangwahyu.mvvm_pattern.di.ViewModelKey;
import com.ujangwahyu.mvvm_pattern.viewmodel.main.MainViewModel;
import com.ujangwahyu.mvvm_pattern.viewmodel.movie.MovieViewModel;
import com.ujangwahyu.mvvm_pattern.viewmodel.tvshow.TvShowViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    abstract ViewModel bindMovieViewModel(MovieViewModel movieViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TvShowViewModel.class)
    abstract ViewModel bindTvShowViewModel(TvShowViewModel tvShowViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}
