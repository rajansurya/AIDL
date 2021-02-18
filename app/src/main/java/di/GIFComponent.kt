package com.society.societygate.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import di.FragmentModule
import di.SocietyApplicationClass
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,ActivitiesModule::class,ViewModelModule::class,AppModule::class,FragmentModule::class])
interface GIFComponent : AndroidInjector<SocietyApplicationClass> {
    @Component.Builder
    interface Builder{
        fun builderApplication():GIFComponent
        @BindsInstance
        fun societyapplicationBind(application: Application):Builder
        @BindsInstance
        fun context(context: Context): Builder
    }
    fun injectApp(application: SocietyApplicationClass)
}