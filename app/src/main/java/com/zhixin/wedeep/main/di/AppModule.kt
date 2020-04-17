package com.zhixin.wedeep.main.di

import com.zhixin.wedeep.common.di.NetWorkModule
import com.zhixin.wedeep.legotest.LegoCoreDataModule
import com.zhixin.wedeep.legotest.legoset.LegoSetModule
import com.zhixin.wedeep.legotest.legotheme.LegoSetThemeModule
import dagger.Module


@Module(includes = [ViewModelModule::class, LegoCoreDataModule::class, NetWorkModule::class, LegoSetThemeModule::class, LegoSetModule::class])
class AppModule {

}
