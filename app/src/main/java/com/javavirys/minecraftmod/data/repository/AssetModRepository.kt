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
import android.content.res.AssetManager
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.mapper.InputStreamToModListJson
import com.javavirys.minecraftmod.data.mapper.ModListJsonToModList
import com.javavirys.minecraftmod.domain.repository.ModRepository
import kotlinx.coroutines.flow.flow


class AssetModRepository(
    private val context: Context
) : ModRepository {

    override fun getAll() = flow {
        val am: AssetManager = context.assets
        val stream = am.open("content.json")
        val modListJson = InputStreamToModListJson().transform(stream)
        val modList = ModListJsonToModList(context).transform(modListJson)
        emit(modList)
    }

    override suspend fun addMod(item: Mod) {
        throw UnsupportedOperationException()
    }

    override suspend fun removeMod(item: Mod) {
        throw UnsupportedOperationException()
    }
}