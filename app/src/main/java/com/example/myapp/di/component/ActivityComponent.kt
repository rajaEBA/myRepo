package com.example.myapp.di.component

import com.example.myapp.di.ActivityScope
import com.example.myapp.di.module.ActivityModule
import com.example.myapp.ui.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: SplashActivity)
}