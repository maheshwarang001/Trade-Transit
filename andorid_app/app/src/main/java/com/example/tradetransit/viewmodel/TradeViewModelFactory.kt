package com.example.tradetransit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class TradeViewModelFactory @Inject constructor(private val userViewModel: UserViewModel) : ViewModelProvider.Factory {

//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
//            modelClass.isAssignableFrom(it.key)
//        }?.value ?: throw IllegalArgumentException("Unknown ViewModel class $modelClass")
//
//        return try {
//            @Suppress("UNCHECKED_CAST")
//            creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return userViewModel as T
    }
}
