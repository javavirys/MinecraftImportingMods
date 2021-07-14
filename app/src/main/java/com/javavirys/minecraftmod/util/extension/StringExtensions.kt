package com.javavirys.minecraftmod.util.extension

import android.net.Uri

fun String?.toUri(): Uri = this?.let { Uri.parse(it) } ?: Uri.EMPTY
