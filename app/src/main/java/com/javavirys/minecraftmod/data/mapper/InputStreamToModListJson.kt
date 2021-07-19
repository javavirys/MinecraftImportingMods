package com.javavirys.minecraftmod.data.mapper

import com.google.gson.Gson
import com.javavirys.minecraftmod.data.entity.ModListJson
import com.javavirys.minecraftmod.util.extension.readTextAndClose
import java.io.InputStream

class InputStreamToModListJson {

    fun transform(mbbgnmdfnmdfgnfgjreozxdaqwsxcderfvbgtbhyomkjhgyhjuiol: InputStream): ModListJson {
        val json = mbbgnmdfnmdfgnfgjreozxdaqwsxcderfvbgtbhyomkjhgyhjuiol.readTextAndClose()
        val gson = Gson()
        return gson.fromJson(json, ModListJson::class.java)
    }
}