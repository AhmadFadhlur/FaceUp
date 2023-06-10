package com.example.faceup.data.repository

import com.example.faceup.network.models.LoginResponse
import com.example.faceup.network.service.ApiService
import com.example.faceup.utils.wrapper.Resource
import com.example.faceup.utils.wrapper.proceed

class DataRepository (private val apiService: ApiService) {

    suspend fun postLogin(email:String, password:String) : Resource<LoginResponse> =
        proceed {
            apiService.postLogin(email,password)
        }

}