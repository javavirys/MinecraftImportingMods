package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.entity.ModJson
import com.javavirys.minecraftmod.util.extension.loadBitmapFromAssets

class ModJsonToMod(private val context: Context) {

    fun transform(value: ModJson) = Mod(
        0,
        value.name,
        value.description,
        value.addonName,
        context.loadBitmapFromAssets("images/${value.imageName}"),
        value.imageName
    )
}