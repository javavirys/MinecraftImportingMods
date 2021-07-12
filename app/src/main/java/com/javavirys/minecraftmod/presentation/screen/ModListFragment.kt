/*
 * Copyright 2021 Vitaliy Sychov
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

package com.javavirys.minecraftmod.presentation.screen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.presentation.adapter.ModAdapter
import com.javavirys.minecraftmod.presentation.viewmodel.ModListViewModel
import com.javavirys.minecraftmod.util.extension.findView
import com.javavirys.minecraftmod.util.extension.setTextColorCompat
import org.koin.androidx.viewmodel.ext.android.viewModel

class ModListFragment : BaseFragment<ModListViewModel>(R.layout.fragment_mod_list) {

    override val model: ModListViewModel by viewModel()

    private val adapter by lazy {
        ModAdapter(
            onItemClick = { model.navigateToModViewer(it) },
            onCheckItem = { model.selectItem(it) }
        )
    }

    private val modsButton by lazy { requireActivity().findView<View>(R.id.modsView) }

    private val modsTitle by lazy { requireActivity().findView<TextView>(R.id.modsTextView) }

    private val favoriteButton by lazy { requireActivity().findView<View>(R.id.favoriteView) }

    private val favoriteTitle by lazy { requireActivity().findView<TextView>(R.id.favoriteTextView) }

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
        initRecyclerView(view)
        model.loadMods()
    }

    private fun initTabs() {
        modsButton.setBackgroundResource(R.drawable.tab_checked)
        favoriteButton.setBackgroundResource(R.drawable.tab_unchecked)
        modsTitle.setTextColorCompat(R.color.white)
        favoriteTitle.setTextColorCompat(R.color.white_50)
        modsButton.setOnClickListener(null)
        favoriteButton.setOnClickListener { model.navigateToFavoriteScreen() }
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findView(R.id.recyclerView)
        recyclerView.adapter = adapter
        model.modsLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
            model.observeDatabase()
        }
        model.favoriteLiveData.observe(viewLifecycleOwner) {
            adapter.updateItem(it)
        }
    }
}