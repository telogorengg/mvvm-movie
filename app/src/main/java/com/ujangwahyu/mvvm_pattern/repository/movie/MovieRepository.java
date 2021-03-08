package com.ujangwahyu.mvvm_pattern.repository.movie;

import com.ujangwahyu.mvvm_pattern.model.movie.ResponseMovie;
import com.ujangwahyu.mvvm_pattern.services.RestService;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.ujangwahyu.mvvm_pattern.utilities.AppConstants.API_KEY;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

public class MovieRepository {

    private RestService restService;

    @Inject
    public MovieRepository(RestService restService) {
        this.restService = restService;
    }


    public Single<ResponseMovie> modelSingle(String language, String page) {
        return restService.getMovie(API_KEY, language, page);
    }
}
