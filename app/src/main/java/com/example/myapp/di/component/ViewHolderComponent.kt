package com.example.myapp.di.component

import com.example.myapp.di.ViewModelScope
import com.example.myapp.di.module.ViewHolderModule
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {
}