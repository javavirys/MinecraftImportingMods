package com.javavirys.minecraftmod.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.javavirys.minecraftmod.data.database.entity.ModDbo.Companion.COLUMN_ADDON_NAME
import com.javavirys.minecraftmod.data.database.entity.ModDbo.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME,
    indices = [Index(value = [COLUMN_ADDON_NAME], unique = true)]
)
data class ModDbo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_DESCRIPTION) val description: String,
    @ColumnInfo(name = COLUMN_ADDON_NAME) val addonName: String,
    val imageName: String
) {

    companion object {
        const val TABLE_NAME = "mods"
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_ADDON_NAME = "addonName"
    }
}