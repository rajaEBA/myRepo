package com.example.myapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapp.MyApplication
import com.example.myapp.di.component.ActivityComponent
import com.example.myapp.di.component.DaggerActivityComponent
import com.example.myapp.di.module.ActivityModule
import com.example.myapp.utils.display.Toaster
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(){

    @Inject
    lateinit var viewModel: VM

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}