package com.example.gs_server.retrofitpost.Demo3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String url = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Heroes>> getHeroes();


}
