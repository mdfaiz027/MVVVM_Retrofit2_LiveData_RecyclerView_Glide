package com.example.mvvvmretrofit2livedatarecyclerviewglide.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.databinding.RecyclerRowBinding;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    //When we get the data we'll set notify dataset changed
    public void setMovieList(List<MovieModel> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder holder, int position) {

        holder.binding.title.setText(this.movieList.get(position).getTitle().toString());
        //Using glide library in order to set the image
        Log.i("tag_image", "onBindViewHolder: " + this.movieList.get(position).getUrl());
        Glide.with(context).load(this.movieList
                        .get(position)
                        .getUrl())
                        .apply(RequestOptions.fitCenterTransform())
                        .into(holder.binding.url);
    }

    @Override
    public int getItemCount() {
        if(this.movieList!=null){
            return this.movieList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding binding;

        public ViewHolder(@NonNull RecyclerRowBinding binding ) {
            super(binding.getRoot());

            this. binding = binding;

        }
    }
}
