package com.ujangwahyu.mvvm_pattern.services;

import com.ujangwahyu.mvvm_pattern.model.movie.ResponseMovie;
import com.ujangwahyu.mvvm_pattern.model.tvshow.ResponseTvShow;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public interface RestService {

    @GET("discover/movie")
    Single<ResponseMovie> getMovie(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page);

    @GET("discover/tv")
    Single<ResponseTvShow> getTv(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page);
}
