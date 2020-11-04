package com.example.creativeplussameer;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("GetCountry/")
    Call<Country> getCountry();

    @POST("GetEmployeeByCountry")
    Call<EmployeeList> getEmployeeList(@Body JsonObject jsonObject);

    @GET("GetEmployeeById/{input}")
    Call<EmployeeDetails> getEmployeeDetails(@Path("input") String input);



}
