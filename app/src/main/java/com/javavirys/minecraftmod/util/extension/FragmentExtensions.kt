package com.javavirys.minecraftmod.util.extension

import android.view.View
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

fun <T : View> Fragment.getColor(@ColorRes colorRes: Int) =
    requireContext().getColorFromRes(colorRes)