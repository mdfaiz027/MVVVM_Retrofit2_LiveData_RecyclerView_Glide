package com.example.mvvvmretrofit2livedatarecyclerviewglide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvvmretrofit2livedatarecyclerviewglide.adapter.MovieListAdapter;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.databinding.ActivityMainBinding;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.model.MovieModel;
import com.example.mvvvmretrofit2livedatarecyclerviewglide.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MovieListAdapter(this, movieModelList);
        binding.recyclerView.setAdapter(adapter);
        
        viewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                
                if(movieModels!=null){
                    movieModelList = movieModels;
                    adapter.setMovieList(movieModels);
                }else {
                    Toast.makeText(MainActivity.this, "No Result Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.makeApiCall();
    }
}