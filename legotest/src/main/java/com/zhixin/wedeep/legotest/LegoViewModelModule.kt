package com.zhixin.wedeep.legotest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhixin.wedeep.common.di.ViewModelFactory
import com.zhixin.wedeep.common.di.ViewModelKey
import com.zhixin.wedeep.legotest.legoset.ui.LegoSetViewModel
import com.zhixin.wedeep.legotest.legoset.ui.LegoSetsViewModel
import com.zhixin.wedeep.legotest.legotheme.ui.LegoThemeViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class LegoViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LegoThemeViewModel::class)
    abstract fun bindThemeViewModel(viewModel: LegoThemeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LegoSetsViewModel::class)
    abstract fun bindLegoSetsViewModel(viewModel: LegoSetsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LegoSetViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: LegoSetViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
