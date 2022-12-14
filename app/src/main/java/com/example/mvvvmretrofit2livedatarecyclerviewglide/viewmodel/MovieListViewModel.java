package com.example.mvvvmretrofit2livedatarecyclerviewglide.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvvmretrofit2livedatarecyclerviewglide.model.MovieModel;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.network.APIService;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieListViewModel extends ViewModel {

    //When we get the response from the api, we inform our activity,
    // which is going to observe the data and update the recyclerview
    private MutableLiveData<List<MovieModel>> moviesList;

    public MovieListViewModel() {
        moviesList = new MutableLiveData<>();
    }

    //function to return the live data
    public MutableLiveData<List<MovieModel>> getMoviesListObserver(){
        return moviesList;
    }

    public void makeApiCall(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);

        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                moviesList.postValue(null);
            }
        });
    }
}
