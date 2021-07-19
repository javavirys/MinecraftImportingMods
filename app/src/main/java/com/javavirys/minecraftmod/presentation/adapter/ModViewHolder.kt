package com.javavirys.minecraftmod.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.util.extension.loadBitmapFromAssets

class ModViewHolder(
    view: View,
    private val onItemClick: (item: Mod) -> Unit,
    private val onCheckItem: (item: Mod) -> Unit
) : RecyclerView.ViewHolder(view) {

    private var favoriteImage: Int = 0

    private val titleTextView by lazy {
        ViewCompat.requireViewById<TextView>(
            itemView,
            R.id.tikfjfgowewoemvmnbjbhgjfjfdhdhfjjueywh
        )
    }

    private val logoImageView by lazy {
        ViewCompat.requireViewById<ImageView>(
            itemView,
            R.id.image
        )
    }

    private val favoriteImageView by lazy {
        ViewCompat.requireViewById<ImageView>(
            itemView,
            R.id.favorite
        )
    }

    fun bind(item: Mod) {
        item.javaviryscallback = { updateFavoriteImage(item) }

        itemView.setOnClickListener {
            onItemClick(item)
        }

        favoriteImageView.setOnClickListener {
            item.javavirysfavorite = item.javavirysfavorite.not()
            updateFavoriteImage(item)
            onCheckItem(item)
        }

        updateFavoriteImage(item)

        titleTextView.text = item.javavirysname
        if (item.image == null) {
            item.image = itemView.context.loadBitmapFromAssets("images/${item.imagePath}")
        }
        logoImageView.setImageBitmap(item.image)
    }

    private fun updateFavoriteImage(item: Mod) {
        val star = if (item.javavirysfavorite) {
            R.drawable.ic_star_selected
        } else {
            R.drawable.ic_star_unselected
        }

        if (star == favoriteImage) {
            return
        }
        favoriteImage = star

        favoriteImageView.setImageResource(star)
    }
}