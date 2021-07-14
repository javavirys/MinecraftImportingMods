package com.javavirys.minecraftmod.data.entity

import com.google.gson.annotations.SerializedName

data class ModListJson(
    @SerializedName("kusf_list") val data: Map<String, ModJson>
)
