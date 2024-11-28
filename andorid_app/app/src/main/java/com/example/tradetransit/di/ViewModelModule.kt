//package com.example.tradetransit.di
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.tradetransit.viewmodel.TradeViewModelFactory
//import com.example.tradetransit.viewmodel.UserViewModel
//import dagger.Binds
//import dagger.MapKey
//import dagger.Module
//import dagger.multibindings.IntoMap
//import kotlin.reflect.KClass
//
//@Module
//abstract class ViewModelModule {
//
//    @Binds
//    abstract fun bindViewModelFactory(factory: TradeViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(UserViewModel::class)
//    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel
//
//}
//
//@MapKey
//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.RUNTIME)
//annotation class ViewModelKey(val value: KClass<out ViewModel>)