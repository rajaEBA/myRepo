package com.example.myapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    //protected abstract fun injectDependencies(fragmentComponent : Fra)
}