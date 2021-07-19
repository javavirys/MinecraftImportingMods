package com.javavirys.minecraftmod.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
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
        items.forEach {
            if (
                item.name == it.name && item.description == it.description
                && item.addonName == it.addonName
            ) {
                it.id = item.id
                if (it.favorite != item.favorite) {
                    it.favorite = item.favorite
                    it.callback?.invoke(it)
                }
            }
        }
    }
}