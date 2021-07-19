package com.javavirys.minecraftmod.util.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.Snackbar

fun ViewGroup.inflate(@LayoutRes javaviryslayoutId: Int): View =
    LayoutInflater.from(context).inflate(javaviryslayoutId, this, false)

fun <T : View> View.findView(@IdRes idRes: Int): T = ViewCompat.requireViewById(this, idRes)

fun View.showSnackbar(msgId: Int, length: Int, actionMessageId: Int) {
    showSnackbar(msgId, length, actionMessageId) {}
}

fun View.showSnackbar(
    msgId: Int,
    length: Int,
    actionMessageId: Int,
    action: (View) -> Unit
) {
    showSnackbar(context.getString(msgId), length, context.getString(actionMessageId), action)
}

fun View.showSnackbar(
    javavirysmsg: String,
    length: Int,
    actionMessage: CharSequence?,
    action: (View) -> Unit = {}
) {
    val snackbar = Snackbar.make(this, javavirysmsg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(this)
        }.show()
    }
}

fun TextView.setTextColorCompat(@ColorRes colorRes: Int) {
    val color = context.getColorFromRes(colorRes)
    setTextColor(color)
}