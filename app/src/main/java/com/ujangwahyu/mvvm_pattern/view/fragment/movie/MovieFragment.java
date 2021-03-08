package com.ujangwahyu.mvvm_pattern.view.fragment.movie;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

import android.content.Context;
import android.os.Bundle;

import com.ujangwahyu.mvvm_pattern.BR;
import com.ujangwahyu.mvvm_pattern.R;
import com.ujangwahyu.mvvm_pattern.base.BaseFragment;
import com.ujangwahyu.mvvm_pattern.databinding.FragmentMovieBinding;
import com.ujangwahyu.mvvm_pattern.model.movie.Movie;
import com.ujangwahyu.mvvm_pattern.viewmodel.movie.MovieView;
import com.ujangwahyu.mvvm_pattern.viewmodel.movie.MovieViewModel;

public class MovieFragment extends BaseFragment<FragmentMovieBinding, MovieViewModel> implements MovieView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm.setNavigator(this);
        vm.loadData();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    public int getBindingVariable() {
        return com.ujangwahyu.mvvm_pattern.BR.vm_movie;
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
    public void showDetail(Movie data) {

    }
}
