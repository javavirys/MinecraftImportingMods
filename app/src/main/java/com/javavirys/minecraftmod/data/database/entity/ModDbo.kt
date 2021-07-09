/*
 * Copyright 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @ColumnInfo(name = COLUMN_ADDON_NAME) val addonName: String
) {

    companion object {
        const val TABLE_NAME = "mods"
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_ADDON_NAME = "addonName"
    }
}