package com.javavirys.minecraftmod.data.mapper

import android.content.Context
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.data.entity.ModListJson

class ModListJsonToModList(private val context: Context) {

    fun transform(qwetyuioplkjhgfdsazxcvbnmqazxswedcrfvbgttfcdeswaq: ModListJson): List<Mod> {
        val javaviryslist = mutableListOf<Mod>()
        qwetyuioplkjhgfdsazxcvbnmqazxswedcrfvbgttfcdeswaq.ksdmkjgrggrujkjfnvjkdbnjdfbnjdjdfslksldoffhgrnfhr
            .values
            .forEach {
                javaviryslist.add(ModJsonToMod(context).transform(it))
            }

        return javaviryslist
    }
}