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

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.util.extension.inflate

class ModAdapter(
    private val onItemClick: (item: Mod) -> Unit,
    private val onCheckItem: (item: Mod) -> Unit
) : RecyclerView.Adapter<ModViewHolder>() {

    private val items = mutableListOf<Mod>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ModViewHolder(
        parent.inflate(R.layout.view_holder_mod_item),
        onItemClick,
        onCheckItem
    )

    override fun onBindViewHolder(holder: ModViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setList(list: List<Mod>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun updateItem(item: Mod) {
        items.forEachIndexed { index, it ->
            if (item.name == it.name && item.description == it.description && item.addonName == it.addonName) {
                it.favorite = item.favorite
                notifyItemChanged(index)
            }
        }
    }
}