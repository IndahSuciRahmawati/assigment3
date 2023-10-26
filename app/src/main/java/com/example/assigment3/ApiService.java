package com.example.assigment3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    public static String BASE_URL = "https://disease.sh/";
    @GET("v3/covid-19/all")
    Call<CovidData> getCovidData();
}
