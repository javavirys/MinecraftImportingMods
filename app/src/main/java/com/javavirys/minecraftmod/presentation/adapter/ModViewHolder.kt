/*
 * Copyright 2021 Vitaliy Sychov. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        Glide.with(logoImageView)
            .load(item.image.second)
            .into(logoImageView)
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