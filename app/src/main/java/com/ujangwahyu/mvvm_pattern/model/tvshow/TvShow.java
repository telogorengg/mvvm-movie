package com.ujangwahyu.mvvm_pattern.model.tvshow;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */

public class TvShow implements Parcelable
{

    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = new ArrayList<>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = new ArrayList<>();
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    public final static Parcelable.Creator<TvShow> CREATOR = new Creator<TvShow>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        public TvShow[] newArray(int size) {
            return (new TvShow[size]);
        }

    }
            ;

    protected TvShow(Parcel in) {
        this.originalName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.genreIds, (java.lang.Integer.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.popularity = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.originCountry, (java.lang.String.class.getClassLoader()));
        this.voteCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.firstAirDate = ((String) in.readValue((String.class.getClassLoader())));
        this.backdropPath = ((String) in.readValue((String.class.getClassLoader())));
        this.originalLanguage = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.voteAverage = ((Double) in.readValue((Double.class.getClassLoader())));
        this.overview = ((String) in.readValue((String.class.getClassLoader())));
        this.posterPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TvShow() {
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(originalName);
        dest.writeList(genreIds);
        dest.writeValue(name);
        dest.writeValue(popularity);
        dest.writeList(originCountry);
        dest.writeValue(voteCount);
        dest.writeValue(firstAirDate);
        dest.writeValue(backdropPath);
        dest.writeValue(originalLanguage);
        dest.writeValue(id);
        dest.writeValue(voteAverage);
        dest.writeValue(overview);
        dest.writeValue(posterPath);
    }

    public int describeContents() {
        return 0;
    }

}

