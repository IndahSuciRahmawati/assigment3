package com.example.assigment3;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private ApiService myApiService;
    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        myApiService = retrofit.create(ApiService.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiService myApi(){
        return myApiService;
    }
}
