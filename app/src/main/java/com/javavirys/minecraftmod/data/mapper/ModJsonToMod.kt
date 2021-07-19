package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.data.entity.ModJson

class ModJsonToMod(private val context: Context) {

    fun transform(plmkijuyhgtredqaesdcxfrstdgbcnvhyfhfflkjhyhbgftrhnfgyrutiyoyiknvfdreredfgh: ModJson) = Mod(
        0,
        plmkijuyhgtredqaesdcxfrstdgbcnvhyfhfflkjhyhbgftrhnfgyrutiyoyiknvfdreredfgh.javavirysname,
        plmkijuyhgtredqaesdcxfrstdgbcnvhyfhfflkjhyhbgftrhnfgyrutiyoyiknvfdreredfgh.description,
        plmkijuyhgtredqaesdcxfrstdgbcnvhyfhfflkjhyhbgftrhnfgyrutiyoyiknvfdreredfgh.addonName,
        null, //context.loadBitmapFromAssets("images/${value.imageName}"),
        plmkijuyhgtredqaesdcxfrstdgbcnvhyfhfflkjhyhbgftrhnfgyrutiyoyiknvfdreredfgh.imageName
    )
}