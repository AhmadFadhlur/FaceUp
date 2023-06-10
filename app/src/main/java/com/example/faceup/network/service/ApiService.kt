package com.example.faceup.network.service

import com.example.faceup.network.models.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(
        @Field("email") email : String,
        @Field("password") password : String,
    ) : LoginResponse
}