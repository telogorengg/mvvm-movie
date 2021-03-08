package com.ujangwahyu.mvvm_pattern.viewmodel.main;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ujangwahyu.mvvm_pattern.base.BaseViewModel;
import com.ujangwahyu.mvvm_pattern.repository.movie.MovieRepository;

import javax.inject.Inject;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public class MainViewModel extends BaseViewModel<MainView> {

    private MovieRepository movieRepository;

    @Inject
    public MainViewModel(@NonNull Application application, MovieRepository movieRepository) {
        super(application);
        this.movieRepository = movieRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (getCompositeDisposable() != null) {
            getCompositeDisposable().clear();

        }
    }

}
