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
package com.javavirys.minecraftmod.presentation.screen

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.presentation.viewmodel.ModListViewModel
import com.javavirys.minecraftmod.util.extension.findView
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrackListFragment : BaseFragment<ModListViewModel>(R.layout.fragment_mod_list) {

    override val model: ModListViewModel by viewModel()

//    private val adapter by lazy { TrackAdapter { model.navigateToTrackScreen(it) } }

    private lateinit var trackRecyclerView: RecyclerView

    private lateinit var progressLayout: ConstraintLayout

    private lateinit var playingLayout: CardView

    private lateinit var coverImageView: ImageView

    private lateinit var playImageView: ImageView

    private lateinit var nextImageView: ImageView

    private lateinit var nameTextView: TextView

    private lateinit var singerTextView: TextView

    private val rotateAnimation = RotateAnimation(
        0f,
        360f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    ).also {
        it.repeatCount = Animation.INFINITE
        it.duration = 3000
        it.interpolator = LinearInterpolator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressLayout = view.findView(R.id.progressLayout)
//        initToolbar()
//        initRecyclerView(view)
    }

    private fun initToolbar() {
        val toolbar = requireActivity().findView<Toolbar>(R.id.toolbar)
//        toolbar.setTitle(R.string.track_list_title)
    }

    private fun initRecyclerView(view: View) {
//        trackRecyclerView = view.findView(R.id.trackRecyclerView)
//        trackRecyclerView.adapter = adapter

//        model.tracksLiveData.observe(viewLifecycleOwner) {
//            if (it is Result.Success) {
//                adapter.addItem(it.data)
//            }
//        }
    }
}