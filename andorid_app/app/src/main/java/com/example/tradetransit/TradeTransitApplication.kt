package com.example.tradetransit

import android.app.Application
import com.example.tradetransit.di.ApplicationComponent
import com.example.tradetransit.di.DaggerApplicationComponent


class TradeTransitApplication:Application() {

    lateinit var applicationComponent: ApplicationComponent;

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this);

    }


}