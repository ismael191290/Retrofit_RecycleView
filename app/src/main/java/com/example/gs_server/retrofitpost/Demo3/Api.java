package com.example.gs_server.retrofitpost.Demo3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    // url a la que haremos la peticion
    String url = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Heroes>> getHeroes();


}
