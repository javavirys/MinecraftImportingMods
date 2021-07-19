package com.javavirys.minecraftmod.util.extension

import android.net.Uri

fun String?.toJavavirysuri(): Uri = this?.let { Uri.parse(it) } ?: Uri.EMPTY
