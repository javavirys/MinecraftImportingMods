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

    override fun getModByAddonName(addonName: String) =
        ModDboToMod(context).transform(modDao.getModByAddonName(addonName))

    override suspend fun addMod(item: Mod) {
        modDao.insert(ModToModDbo().transform(item))
    }

    override suspend fun removeMod(item: Mod) = modDao.delete(ModToModDbo().transform(item))
}