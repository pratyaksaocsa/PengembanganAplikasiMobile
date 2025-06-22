package com.ocsa.helloworldapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("users") //BASE-URL + /users
    Call<UserResponse> getAllUsers();

}
