package com.javavirys.minecraftmod.data.mapper

import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.data.database.entity.ModDbo

class ModToModDbo {

    fun transform(value: Mod) = ModDbo(
        value.id.toLong(),
        value.name,
        value.description,
        value.addonName,
        value.image.first
    )
}