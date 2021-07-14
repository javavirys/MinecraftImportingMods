package com.javavirys.minecraftmod.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.javavirys.minecraftmod.data.database.dao.ModDao
import com.javavirys.minecraftmod.data.database.entity.ModDbo

@Database(
    entities = [
        ModDbo::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getModDao(): ModDao
}