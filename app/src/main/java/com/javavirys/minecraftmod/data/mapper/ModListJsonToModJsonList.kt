package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.entity.ModListJson

class ModListJsonToModList(private val context: Context) {

    fun transform(value: ModListJson): List<Mod> {
        val list = mutableListOf<Mod>()
        value.data
            .values
            .forEach {
                list.add(ModJsonToMod(context).transform(it))
            }

        return list
    }
}