package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseFactory.getDatabaseInstance(get()) }
    single { get<AppDatabase>().getModDao() }
}