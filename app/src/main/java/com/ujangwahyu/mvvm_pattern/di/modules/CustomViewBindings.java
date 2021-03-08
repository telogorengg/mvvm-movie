package com.ujangwahyu.mvvm_pattern.di.modules;

import android.provider.SyncStateContract;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ujangwahyu.mvvm_pattern.custom.EmptyRecyclerView;

/**
 * Created by with love by Ujang Wahyu on 2020-01-07.
 * Email : ujangwahyusst@gmail.com
 * Company : Indocyber Global Technology
 * Linkedin : linkedin.com/in/ujangwahyu
 */
public class CustomViewBindings {

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(EmptyRecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }


    @BindingAdapter("android:rating")
    public static void bindRating(RatingBar view, double rating) {
        if (view.getRating() != rating) {
            view.setRating((float)(rating/2));
        }
    }

}
