package com.example.mvvm_architecture_android.di.module

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm_architecture_android.data.repository.TopHeadlineRepository
import com.example.mvvm_architecture_android.di.ActivityContext
import com.example.mvvm_architecture_android.ui.base.ViewModelProviderFactory
import com.example.mvvm_architecture_android.ui.topheadline.TopHeadlineAdapter
import com.example.mvvm_architecture_android.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides
import java.util.ArrayList


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return androidx.lifecycle.ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}