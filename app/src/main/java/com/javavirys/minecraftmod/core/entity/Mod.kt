package com.javavirys.minecraftmod.core.entity

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Mod(
    var id: Int,
    val name: String,
    val description: String,
    val addonName: String,
    val image: Pair<String, Bitmap?>,
    var favorite: Boolean = false
) : Parcelable