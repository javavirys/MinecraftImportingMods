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
        val stream = am.open(CONTENT_NAME)
        val modListJson = InputStreamToModListJson().transform(stream)
        val modList = ModListJsonToModList(context).transform(modListJson)
        emit(modList)
    }

    override fun getModByAddonName(addonName: String): Mod {
        TODO("Not yet implemented")
    }

    override suspend fun addMod(item: Mod) {
        throw UnsupportedOperationException()
    }

    override suspend fun removeMod(item: Mod) {
        throw UnsupportedOperationException()
    }

    companion object {
        private const val CONTENT_NAME = "content.json"
    }
}