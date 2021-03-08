package com.ujangwahyu.mvvm_pattern.di.modules;

import com.ujangwahyu.mvvm_pattern.view.fragment.movie.MovieFragment;
import com.ujangwahyu.mvvm_pattern.view.fragment.tvshow.TvShowFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

@Module
public abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract MovieFragment provideMovieFragment();

    @ContributesAndroidInjector
    abstract TvShowFragment provideTvShowFragment();
}
