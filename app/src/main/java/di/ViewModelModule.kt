package com.society.societygate.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.papaer.gifview.MainActivityModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  ViewModel.class as key,
     * and a Provider that will build a ViewModel
     * object.
     *
     * */


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityModel::class)
    protected abstract fun dashViewModel(ViewModel: MainActivityModel): ViewModel

}