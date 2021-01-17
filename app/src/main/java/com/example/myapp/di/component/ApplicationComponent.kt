package com.example.myapp.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.myapp.MyApplication
import com.example.myapp.data.NetworkService
import com.example.myapp.data.local.db.DatabaseService
import com.example.myapp.data.repository.UserRepository
import com.example.myapp.di.module.ApplicationContext
import com.example.myapp.di.module.ApplicationModule
import com.example.myapp.utils.netwwork.NetworkHelper
import com.example.myapp.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app : MyApplication)

    fun getApplication() : Application

    @ApplicationContext
    fun getContext() : Context

    fun getNetworksService() : NetworkService

    fun getDataBaseService() : DatabaseService

    fun getSharedPreferences() : SharedPreferences

    fun getNetworkHelper() : NetworkHelper

    fun getUserRepository(): UserRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}