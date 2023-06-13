package com.example.faceup.data.repository

import com.example.faceup.network.models.login.LoginBody
import com.example.faceup.network.models.login.LoginResponse
import com.example.faceup.network.models.register.RegisterBody
import com.example.faceup.network.models.register.RegisterResponse
import com.example.faceup.network.service.AuthApiService
import com.example.faceup.utils.wrapper.Resource
import com.example.faceup.utils.wrapper.proceed

class DataRepository (private val authApiService: AuthApiService) {

    suspend fun postLogin(loginBody: LoginBody) : Resource<LoginResponse> =
        proceed {
            authApiService.postLogin(loginBody)
        }

    suspend fun postRegist (registerBody: RegisterBody) : Resource<RegisterResponse> =
        proceed {
            authApiService.postRegister(registerBody)
        }

}