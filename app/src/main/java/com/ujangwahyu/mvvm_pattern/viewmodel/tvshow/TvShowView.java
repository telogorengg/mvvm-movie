package com.ujangwahyu.mvvm_pattern.viewmodel.tvshow;

import com.ujangwahyu.mvvm_pattern.base.BaseView;
import com.ujangwahyu.mvvm_pattern.model.tvshow.TvShow;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public interface TvShowView extends BaseView {
    void showDetail(TvShow data);
}
