package com.example.newsapplicationprojectdaggerhiltjetpackcompose.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.di.ActivityContext
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.repository.TopHeadlineRepository
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.ui.base.ViewModelProviderFactory
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.ui.topheadline.TopHeadlineAdapter
import com.example.newsapplicationprojectdaggerhiltjetpackcompose.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsListViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}