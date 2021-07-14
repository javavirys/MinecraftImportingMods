package com.javavirys.minecraftmod.di

import android.content.Context
import androidx.room.Room
import com.javavirys.minecraftmod.data.database.AppDatabase

object DatabaseFactory {

    private const val DATABASE_NAME = "media-player"

    private var appDatabase: AppDatabase? = null

    fun getDatabaseInstance(applicationContext: Context): AppDatabase {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()
        }

        return appDatabase!!
    }
}