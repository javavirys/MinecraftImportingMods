package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.database.entity.ModDbo
import com.javavirys.minecraftmod.util.extension.loadBitmapFromAssets

class ModDboToMod(private val context: Context) {

    fun transform(value: ModDbo) = Mod(
        value.id.toInt(),
        value.name,
        value.description,
        value.addonName,
        context.loadBitmapFromAssets("images/${value.imageName}"),
        value.imageName,
        true
    )
}