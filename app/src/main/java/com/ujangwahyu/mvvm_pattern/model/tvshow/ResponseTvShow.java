package com.ujangwahyu.mvvm_pattern.model.tvshow;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public class ResponseTvShow implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalTvShows;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private ArrayList<TvShow> results = null;
    public final static Parcelable.Creator<ResponseTvShow> CREATOR = new Creator<ResponseTvShow>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponseTvShow createFromParcel(Parcel in) {
            return new ResponseTvShow(in);
        }

        public ResponseTvShow[] newArray(int size) {
            return (new ResponseTvShow[size]);
        }

    }
            ;

    protected ResponseTvShow(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalTvShows = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (TvShow.class.getClassLoader()));
    }

    public ResponseTvShow() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalTvShows() {
        return totalTvShows;
    }

    public void setTotalTvShows(Integer totalTvShows) {
        this.totalTvShows = totalTvShows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<TvShow> getTvShows() {
        return results;
    }

    public void setTvShows(ArrayList<TvShow> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalTvShows);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

}