package com.ujangwahyu.mvvm_pattern.view.fragment.tvshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ujangwahyu.mvvm_pattern.BR;
import com.ujangwahyu.mvvm_pattern.R;
import com.ujangwahyu.mvvm_pattern.base.BaseFragment;
import com.ujangwahyu.mvvm_pattern.databinding.FragmentMovieBinding;
import com.ujangwahyu.mvvm_pattern.databinding.FragmentTvShowBinding;
import com.ujangwahyu.mvvm_pattern.model.tvshow.TvShow;
import com.ujangwahyu.mvvm_pattern.viewmodel.tvshow.TvShowView;
import com.ujangwahyu.mvvm_pattern.viewmodel.tvshow.TvShowViewModel;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

public class TvShowFragment extends BaseFragment<FragmentMovieBinding, TvShowViewModel> implements TvShowView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm.setNavigator(this);
        vm.loadData();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_tv_show;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm_tvshow;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showDetail(TvShow data) {

    }
}
