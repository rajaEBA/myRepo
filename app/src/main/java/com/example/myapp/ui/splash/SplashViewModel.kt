package com.example.myapp.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.myapp.data.repository.UserRepository
import com.example.myapp.ui.base.BaseViewModel
import com.example.myapp.utils.common.Event
import com.example.myapp.utils.netwwork.NetworkHelper
import com.example.myapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    val userRepository: UserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper){
    val launchDummy: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    override fun onCreate() {
        launchDummy.postValue(Event(emptyMap()))
    }
}