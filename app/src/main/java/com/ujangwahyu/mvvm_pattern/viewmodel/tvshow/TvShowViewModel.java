package com.ujangwahyu.mvvm_pattern.viewmodel.tvshow;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import com.ujangwahyu.mvvm_pattern.R;
import com.ujangwahyu.mvvm_pattern.base.BaseViewModel;
import com.ujangwahyu.mvvm_pattern.model.tvshow.ResponseTvShow;
import com.ujangwahyu.mvvm_pattern.model.tvshow.TvShow;
import com.ujangwahyu.mvvm_pattern.repository.tvshow.TvShowRepository;
import com.ujangwahyu.mvvm_pattern.view.adapter.tvshow.TvShowAdapter;

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
public class TvShowViewModel extends BaseViewModel<TvShowView> implements TvShowAdapter.OnItemClickCallback {

    private final MutableLiveData<ResponseTvShow> responseTvShow = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TvShow>> tvshows = new MutableLiveData<>();
    private TvShowRepository tvShowRepository;
    private TvShowAdapter adapter;
    public ObservableBoolean isRefresh = new ObservableBoolean();

    @Inject
    public TvShowViewModel(@NonNull Application application, TvShowRepository tvShowRepository) {
        super(application);
        this.tvShowRepository = tvShowRepository;
        this.adapter = new TvShowAdapter(R.layout.item_tv_show, this);
        this.adapter.setOnItemClickCallback(this);
    }

    public void setTvShowInAdapter(ArrayList<TvShow> tvshow) {
        this.adapter.setTvShow(tvshow);
        this.adapter.notifyDataSetChanged();
    }

    public TvShowAdapter getAdapter() {
        return adapter;
    }

    public void loadData() {

        getNavigator().showLoading();

        getCompositeDisposable().add(tvShowRepository.modelSingle("en-US", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseTvShow>() {
                    @Override
                    public void onSuccess(ResponseTvShow tvshow) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        responseTvShow.setValue(tvshow);
                        tvshows.setValue(responseTvShow.getValue().getTvShows());
                        setTvShowInAdapter(getTvShow().getValue());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getNavigator().hideLoading();
                        isRefresh.set(false);
                        Log.d("Error get tvshow", e.getMessage().toString());
                    }
                }));
    }


    public TvShow getTvShowAt(Integer index) {
        if (responseTvShow.getValue() != null &&
                index != null &&
                responseTvShow.getValue().getTvShows().size() > index) {
            return responseTvShow.getValue().getTvShows().get(index);
        }
        return null;
    }

    public MutableLiveData<ArrayList<TvShow>> getTvShow() {
        return tvshows;
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
    public void onItemClicked(TvShow data) {
        getNavigator().showDetail(data);
    }

    public void onRefresh() {
        isRefresh.set(true);
        loadData();
    }

}
