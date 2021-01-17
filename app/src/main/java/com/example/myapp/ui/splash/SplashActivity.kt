package com.example.myapp.ui.splash

import android.os.Bundle
import com.example.myapp.R
import com.example.myapp.di.component.ActivityComponent
import com.example.myapp.ui.base.BaseActivity
import com.example.myapp.utils.common.Event
import com.example.myapp.utils.log.Logger
import java.util.Observer

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupObservers() {
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
//        viewModel.launchDummy.observe(this, Observer<Event<Map<String, String>>> {
//        })
    }
}