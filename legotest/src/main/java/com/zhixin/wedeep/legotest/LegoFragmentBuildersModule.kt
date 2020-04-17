package com.zhixin.wedeep.legotest


import com.zhixin.wedeep.legotest.legoset.ui.LegoSetFragment
import com.zhixin.wedeep.legotest.legoset.ui.LegoSetsFragment
import com.zhixin.wedeep.legotest.legotheme.ui.LegoThemeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class LegoFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeThemeFragment(): LegoThemeFragment

    @ContributesAndroidInjector
    abstract fun contributeLegoSetsFragment(): LegoSetsFragment

    @ContributesAndroidInjector
    abstract fun contributeLegoSetFragment(): LegoSetFragment
}
