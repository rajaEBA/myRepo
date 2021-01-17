package com.example.myapp

import android.app.Application
import com.example.myapp.di.component.ApplicationComponent

class MyApplication : Application() {
    lateinit var applicationComponent : ApplicationComponent

}