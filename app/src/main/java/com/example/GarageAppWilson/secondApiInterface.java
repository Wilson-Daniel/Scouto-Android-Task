package com.example.GarageAppWilson;

import retrofit2.Call;
import retrofit2.http.GET;

public interface secondApiInterface {

    @GET("0?format=json")
    Call<JsonArrmodel> getModel();
}
