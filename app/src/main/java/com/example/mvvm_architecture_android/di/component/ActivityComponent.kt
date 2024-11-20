package com.example.mvvm_architecture_android.di.component

import com.example.mvvm_architecture_android.ui.topheadline.TopHeadlineActivity
import com.example.mvvm_architecture_android.di.ActivityScope
import com.example.mvvm_architecture_android.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: TopHeadlineActivity)
}