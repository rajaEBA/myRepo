package com.example.myapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.myapp.BuildConfig
import com.example.myapp.MyApplication
import com.example.myapp.data.NetworkService
import com.example.myapp.data.Networking
import com.example.myapp.data.local.db.DatabaseService
import com.example.myapp.utils.netwwork.NetworkHelper
import com.example.myapp.utils.rx.RxSchedulerProvider
import com.example.myapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @Singleton
    fun provideApplication() : Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext() : Context = application

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider() : SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences() : SharedPreferences{
        return application.getSharedPreferences("project-prefs",Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(
            application,
            DatabaseService::class.java,
            "bootcamp-instagram-project-db"
        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}