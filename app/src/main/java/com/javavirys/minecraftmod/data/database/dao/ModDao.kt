package com.javavirys.minecraftmod.data.database.dao

import androidx.room.*
import com.javavirys.minecraftmod.data.database.entity.ModDbo
import kotlinx.coroutines.flow.Flow

@Dao
interface ModDao {

    @Query("SELECT * FROM ${ModDbo.TABLE_NAME}")
    fun getAll(): Flow<List<ModDbo>>

    @Query("SELECT * FROM ${ModDbo.TABLE_NAME} WHERE ${ModDbo.COLUMN_ADDON_NAME} = :addonName")
    fun getModByAddonName(addonName: String): ModDbo

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(modDbo: ModDbo): Long

    @Delete
    suspend fun delete(vararg modDbo: ModDbo)
}