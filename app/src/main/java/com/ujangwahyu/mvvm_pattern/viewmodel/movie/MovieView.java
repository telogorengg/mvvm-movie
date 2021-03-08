package com.ujangwahyu.mvvm_pattern.viewmodel.movie;

import com.ujangwahyu.mvvm_pattern.base.BaseView;
import com.ujangwahyu.mvvm_pattern.model.movie.Movie;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public interface MovieView extends BaseView {
    void showDetail(Movie data);
}
