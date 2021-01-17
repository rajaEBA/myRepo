package com.example.myapp.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.data.repository.UserRepository
import com.example.myapp.ui.base.BaseActivity
import com.example.myapp.ui.splash.SplashViewModel
import com.example.myapp.utils.ViewModelProviderFactory
import com.example.myapp.utils.netwwork.NetworkHelper
import com.example.myapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)

}