package com.example.mvvvmretrofit2livedatarecyclerviewglide.network;

import com.example.mvvvmretrofit2livedatarecyclerviewglide.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//To make API call through retrofit
public interface APIService {

    @GET("photos")
    Call<List<MovieModel>> getMovieList();
}
