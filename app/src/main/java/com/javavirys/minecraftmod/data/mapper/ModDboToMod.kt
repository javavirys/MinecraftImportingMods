package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.data.database.entity.ModDbo

class ModDboToMod(private val context: Context) {

    fun transform(plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk: ModDbo) = Mod(
        plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk.id.toInt(),
        plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk.name,
        plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk.description,
        plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk.addonName,
        null, //context.loadBitmapFromAssets("images/${value.imageName}"),
        plmjkuyhbgtrfdeswqfsjdklrioroflfvmkfjdjfkgjgulfyfhfhfhfhhfhjkjkjk.imageName,
        true
    )
}