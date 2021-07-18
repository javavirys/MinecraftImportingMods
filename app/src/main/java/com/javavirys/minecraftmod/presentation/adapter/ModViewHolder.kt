package com.javavirys.minecraftmod.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Mod

class ModViewHolder(
    view: View,
    private val onItemClick: (item: Mod) -> Unit,
    private val onCheckItem: (item: Mod) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val titleTextView by lazy {
        ViewCompat.requireViewById<TextView>(
            itemView,
            R.id.title
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
        item.callback = { updateFavoriteImage(item) }

        itemView.setOnClickListener {
            onItemClick(item)
        }

        favoriteImageView.setOnClickListener {
            item.favorite = item.favorite.not()
            updateFavoriteImage(item)
            onCheckItem(item)
        }

        updateFavoriteImage(item)

        titleTextView.text = item.name
        logoImageView.setImageBitmap(item.image)
    }

    private fun updateFavoriteImage(item: Mod) {
        val star = if (item.favorite) {
            R.drawable.ic_star_selected
        } else {
            R.drawable.ic_star_unselected
        }

        Glide.with(favoriteImageView)
            .load(star)
            .into(favoriteImageView)
    }
}