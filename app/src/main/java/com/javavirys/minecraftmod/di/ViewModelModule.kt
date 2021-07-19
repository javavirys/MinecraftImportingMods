package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel {
        ModListViewModel(get(), get(named(ASSET_QUALIFIER)), get(named(DATABASE_QUALIFIER)))
    }
    viewModel { FavoriteModListViewModel(get(), get(named(DATABASE_QUALIFIER))) }
    viewModel {
        ViewerViewModel(get(), get(), get(named(DATABASE_QUALIFIER)))
    }
}