package com.example.lenovo.api.network;

import com.example.lenovo.api.model.UserResponse;
import com.example.lenovo.api.model.UserkuResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/")
    Call<UserResponse> getUser(@Query("results") int result);

    @Headers("Authorization: Bearer TS6Jaqfo61rBStBUYjnuLQfhIp16sHicXcSs")
    @FormUrlEncoded
    @POST("public-api/users")
    Call<UserkuResponse> postUserku(@Field("email") String email, @Field("first_name") String firstName,
                                    @Field("last_name") String lastName, @Field("gender") String gender);

}
