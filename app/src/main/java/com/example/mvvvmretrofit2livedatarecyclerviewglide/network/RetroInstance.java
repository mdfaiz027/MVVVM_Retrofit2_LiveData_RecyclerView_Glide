package com.example.mvvvmretrofit2livedatarecyclerviewglide.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//To make API call through retrofit
public class RetroInstance {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/"; //photos";

    private static Retrofit retrofit;

    public static Retrofit getRetroClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
