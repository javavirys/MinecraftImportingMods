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

package com.javavirys.minecraftmod.data.repository

import android.content.Context
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.database.dao.ModDao
import com.javavirys.minecraftmod.data.mapper.ModDboToMod
import com.javavirys.minecraftmod.data.mapper.ModToModDbo
import com.javavirys.minecraftmod.domain.repository.ModRepository
import kotlinx.coroutines.flow.map

class DatabaseModRepository(
    private val context: Context,
    private val modDao: ModDao
) : ModRepository {

    override fun getAll() = modDao.getAll()
        .map { list -> list.map { ModDboToMod(context).transform(it) } }

    override suspend fun addMod(item: Mod) {
        modDao.insert(ModToModDbo().transform(item))
    }

    override suspend fun removeMod(item: Mod) = modDao.delete(ModToModDbo().transform(item))
}