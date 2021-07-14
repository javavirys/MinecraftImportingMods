package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.presentation.navigation.MainRouter
import com.javavirys.minecraftmod.presentation.navigation.SplashRouter
import org.koin.dsl.module

val navigationModule = module {
    factory { SplashRouter(get()) }
    factory { MainRouter(get()) }
}