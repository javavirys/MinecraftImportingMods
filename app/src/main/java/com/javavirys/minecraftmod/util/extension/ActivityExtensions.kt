package com.javavirys.minecraftmod.util.extension

import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.view.View
import androidx.annotation.IdRes
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity


fun <T : View> FragmentActivity.findView(@IdRes idRes: Int): T =
    ActivityCompat.requireViewById(this, idRes)

fun PackageManager.isPackageInstalled(packageName: String) =
    try {
        getPackageInfo(packageName, 0)
        true
    } catch (e: NameNotFoundException) {
        false
    }