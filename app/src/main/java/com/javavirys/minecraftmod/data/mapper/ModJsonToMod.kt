package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.entity.ModJson

class ModJsonToMod(private val context: Context) {

    fun transform(value: ModJson) = Mod(
        0,
        value.name,
        value.description,
        value.addonName,
        null, //context.loadBitmapFromAssets("images/${value.imageName}"),
        value.imageName
    )
}