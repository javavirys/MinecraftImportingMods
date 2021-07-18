package com.javavirys.minecraftmod.domain.repository

import com.javavirys.minecraftmod.core.entity.Mod
import kotlinx.coroutines.flow.Flow

interface ModRepository {

    fun getAll(): Flow<List<Mod>>

    fun getModByAddonName(addonName: String): Mod

    suspend fun addMod(item: Mod)

    suspend fun removeMod(item: Mod)
}