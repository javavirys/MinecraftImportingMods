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
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Result
import com.javavirys.minecraftmod.presentation.viewmodel.SplashViewModel
import com.javavirys.minecraftmod.util.extension.findView
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    private val model: SplashViewModel by viewModel()

    private val linearProgressIndicator by lazy { findView<LinearProgressIndicator>(R.id.linearProgressIndicator) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION }

        model.loadingLiveData.observe(this) {
            when (it) {
                is Result.Progress -> linearProgressIndicator.progress = it.progress
                is Result.Success -> model.navigateToMainScreen()
                is Result.Error -> throw UnsupportedOperationException()
            }
        }

        model.load()
    }
}