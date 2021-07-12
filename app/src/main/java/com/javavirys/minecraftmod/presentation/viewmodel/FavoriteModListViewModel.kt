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
package com.javavirys.minecraftmod.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.domain.repository.ModRepository
import com.javavirys.minecraftmod.presentation.navigation.MainRouter

class FavoriteModListViewModel(
    private val router: MainRouter,
    private val databaseModRepository: ModRepository
) : BaseViewModel() {

    val modsLiveData = MutableLiveData<List<Mod>>()

    fun loadMods() {
        subscribeOnFlow(
            backgroundCode = { databaseModRepository.getAll() },
            foregroundCode = {
                modsLiveData.value = it
            }
        )
    }

    fun selectItem(item: Mod) {
        if (item.favorite) {
            launch(
                backgroundCode = { databaseModRepository.addMod(item) }
            )
        } else {
            launch(
                backgroundCode = { databaseModRepository.removeMod(item) }
            )
        }
    }

    fun navigateToModListScreen() {
        router.navigateToModsScreen()
    }

    fun navigateToModViewer(item: Mod) {
        router.navigateToViewerScreen(item)
    }
}