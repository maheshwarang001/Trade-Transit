package com.example.tradetransit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tradetransit.model.LoginBody
import com.example.tradetransit.retrofit.TradeApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val tradeApi : TradeApi) {
    private val _userLoggedIn = MutableStateFlow<Boolean?>(null)
    val userLoggedIn : StateFlow<Boolean?> get() = _userLoggedIn


    suspend fun userLogin(loginBody: LoginBody){
        val result = tradeApi.login(loginBody)
        if(result.isSuccessful && result.body() != null){
            _userLoggedIn.value = true
        }
        else if(result.code() != 200){
            _userLoggedIn.value = false
        }

    }
}