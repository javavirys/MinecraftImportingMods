package com.javavirys.minecraftmod

import android.app.Application
import com.javavirys.minecraftmod.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MinecraftModApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MinecraftModApplication)
            modules(
                listOf(
                    appModule,
                    databaseModule,
                    repositoryModule,
                    navigationModule,
                    viewModelModule
                )
            )
        }
    }
}