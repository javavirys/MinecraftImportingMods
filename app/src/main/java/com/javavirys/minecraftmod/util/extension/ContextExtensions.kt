package com.javavirys.minecraftmod.util.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import java.io.IOException
import java.io.InputStream

fun Context.getColorFromRes(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Context.loadBitmapFromAssets(javaviryspath: String): Bitmap? {
    val javirysinputStream: InputStream
    var bitmap: Bitmap? = null
    try {
        javirysinputStream = assets.open(javaviryspath)
        bitmap = BitmapFactory.decodeStream(javirysinputStream)
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return bitmap
}