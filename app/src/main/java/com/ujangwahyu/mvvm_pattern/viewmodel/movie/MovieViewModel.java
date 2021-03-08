package com.ujangwahyu.mvvm_pattern.viewmodel.movie;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.ujangwahyu.mvvm_pattern.R;
import com.ujangwahyu.mvvm_pattern.base.BaseObservableViewModel;
import com.ujangwahyu.mvvm_pattern.model.movie.Movie;
import com.ujangwahyu.mvvm_pattern.model.movie.ResponseMovie;
import com.ujangwahyu.mvvm_pattern.repository.movie.MovieRepository;
import com.ujangwahyu.mvvm_pattern.view.adapter.movie.MovieAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.ujangwahyu.mvvm_pattern.utilities.AppConstants.BASE_IMAGE;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public class MovieViewModel extends BaseObservableViewModel<MovieView> implements MovieAdapter.OnItemClickCallback {

    private final MutableLiveData<ResponseMovie> responseMovie = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();
    private MovieRepository movieRepository;
    private MovieAdapter adapter;
    public ObservableBoolean isRefresh = new ObservableBoolean();

    @Inject
    public MovieViewModel(@NonNull Application application, MovieRepository movieRepository) {
        super(application);
        this.movieRepository = movieRepository;
        this.adapter = new MovieAdapter(R.layout.item_movie, this);
        this.adapter.setOnItemClickCallback(this);
    }

    public void setMovieInAdapter(ArrayList<Movie> movie) {
        this.adapter.setMovie(movie);
        this.adapter.notifyDataSetChanged();
    }

    public MovieAdapter getAdapter() {
        return adapter;
    }

    public void loadData() {

        getNavigator().showLoading();

        getCompositeDisposable().add(movieRepository.modelSingle("en-US", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseMovie>() {
                    @Override
                    public void onSuccess(ResponseMovie movie) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        responseMovie.setValue(movie);
                        movies.setValue(responseMovie.getValue().getResults());
                        setMovieInAdapter(getMovie().getValue());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        Log.d("Error get movie", e.getMessage().toString());
                    }
                }));
    }

    public Movie getMovieAt(Integer index) {
        if (responseMovie.getValue() != null &&
                index != null &&
                responseMovie.getValue().getResults().size() > index) {
            return responseMovie.getValue().getResults().get(index);
        }
        return null;
    }

    public MutableLiveData<ArrayList<Movie>> getMovie() {
        return movies;
    }

    public String getPoster(String imageUrl){
        return BASE_IMAGE + imageUrl;
    }

    public String getOverview(String overview){
        try {
            return overview.substring(0,100) +" [More] ";
        }catch (Exception e){
            return " [More] ";
        }
    }

    @Override
    public void onItemClicked(Movie data) {
        getNavigator().showDetail(data);
    }

    public void onRefresh() {
        isRefresh.set(true);
        loadData();
    }
}
