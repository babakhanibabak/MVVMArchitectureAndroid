package com.example.mvvm_architecture_android.di.component

import android.content.Context
import com.example.mvvm_architecture_android.MVVMApplication
import com.example.mvvm_architecture_android.data.api.NetworkService
import com.example.mvvm_architecture_android.data.repository.TopHeadlineRepository
import com.example.mvvm_architecture_android.di.ApplicationContext
import com.example.mvvm_architecture_android.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext():Context

    fun getNetworkService():NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository
}