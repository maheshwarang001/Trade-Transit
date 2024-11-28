package com.example.tradetransit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tradetransit.model.LoginBody
import com.example.tradetransit.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class UserViewModel @Inject constructor(val loginRepository: LoginRepository): ViewModel() {

    val loggedIn: StateFlow<Boolean?> get() = loginRepository.userLoggedIn

    private val _uiUsername = MutableStateFlow("")
    val usernameState : StateFlow<String> get() = _uiUsername.asStateFlow()

    private val _uiPassword = MutableStateFlow("")
    val password : StateFlow<String> get() = _uiPassword.asStateFlow()

    private val _uiLoading = MutableStateFlow(false);
    val loading : StateFlow<Boolean> get()  = _uiLoading.asStateFlow()

    private val _buttonDisable = MutableStateFlow(false);
    val buttonDisable : StateFlow<Boolean> get() = _buttonDisable.asStateFlow()


    private val _uiLoginError = MutableStateFlow<String?>(null)
    val uiLoginError : StateFlow<String?> get() = _uiLoginError.asStateFlow()

    fun updateUsername(username: String){
        _uiUsername.value = username
    }

    fun updatePassword(password: String){
        _uiPassword.value = password
    }

    fun clearError() {
        _uiLoginError.value = null
    }


    suspend fun loginButtonClicked() {
        if (isLoginInputValid()) {
            _uiLoading.value = true;
            _buttonDisable.value = true;
            try {
                loginRepository.userLogin(LoginBody(_uiUsername.value, _uiPassword.value))
            } catch (e: Exception) {
                _uiLoginError.value = e.message ?: "An unknown error occurred"
            }
            _uiLoading.value = false;
            _buttonDisable.value = false;

        } else {
            Log.d("LOIGN","INVALID")
            _uiLoginError.value = "Invalid username or password"
        }
    }

    private fun isLoginInputValid(): Boolean {
        return _uiUsername.value.isNotBlank() && _uiPassword.value.isNotBlank()
    }


}