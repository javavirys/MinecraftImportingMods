package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.ActivityProvider
import org.koin.dsl.module

val appModule = module {
    single { ActivityProvider(get()) }
}