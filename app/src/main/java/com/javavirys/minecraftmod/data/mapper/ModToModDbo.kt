package com.javavirys.minecraftmod.data.mapper

import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.data.database.entity.ModDbo

class ModToModDbo {

    fun transform(lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng: Mod) = ModDbo(
        lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng.id.toLong(),
        lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng.name,
        lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng.description,
        lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng.addonName,
        lsmdfkndslnsdngsdngvmmdngngjfngjkfdgjndfng.imagePath
    )
}