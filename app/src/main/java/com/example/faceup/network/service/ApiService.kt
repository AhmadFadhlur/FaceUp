package com.example.faceup.network.service

import com.example.faceup.network.models.login.LoginResponse
import com.example.faceup.network.models.register.RegisterResponse
import retrofit2.http.Body
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

    @FormUrlEncoded
    @POST("register")
    suspend fun postRegister(
        @Field("nama") nama : String,
        @Field("email") email : String,
        @Field("password") password : String,
    ) : RegisterResponse
}