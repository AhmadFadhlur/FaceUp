package com.example.faceup.data.repository

import com.example.faceup.network.models.login.LoginResponse
import com.example.faceup.network.models.register.RegisterResponse
import com.example.faceup.network.service.ApiService
import com.example.faceup.utils.wrapper.Resource
import com.example.faceup.utils.wrapper.proceed

class DataRepository (private val apiService: ApiService) {

    suspend fun postLogin(email:String, password:String) : Resource<LoginResponse> =
        proceed {
            apiService.postLogin(email,password)
        }

    suspend fun postRegist (nama:String,email:String, password: String) : Resource<RegisterResponse> =
        proceed {
            apiService.postRegister(nama,email, password)
        }

}