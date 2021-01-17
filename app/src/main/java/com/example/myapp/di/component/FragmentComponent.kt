package com.example.myapp.di.component

import com.example.myapp.di.FragmentScope
import com.example.myapp.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {
}