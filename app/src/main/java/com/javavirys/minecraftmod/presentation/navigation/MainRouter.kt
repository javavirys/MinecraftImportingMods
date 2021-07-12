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

package com.javavirys.minecraftmod.presentation.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.javavirys.minecraftmod.ActivityProvider
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.presentation.screen.FavoriteModListFragmentDirections
import com.javavirys.minecraftmod.presentation.screen.ModListFragmentDirections


class MainRouter(private val activityProvider: ActivityProvider) {

    fun navigateToModsScreen() {
        activityProvider.activeActivity
            ?.findNavController(R.id.fragmentContainer)
            ?.navigate(FavoriteModListFragmentDirections.actionFavoriteModListFragmentToModListFragment())
    }

    fun navigateToFavoriteScreen() {
        val navController = activityProvider.activeActivity
            ?.findNavController(R.id.fragmentContainer)
        navController?.navigate(ModListFragmentDirections.actionModListFragmentToFavoriteModListFragment())
    }

    fun navigateToViewerScreen(item: Mod) {
        val navController = activityProvider.activeActivity
            ?.findNavController(R.id.fragmentContainer)
        val newItem = item.copy(image = Pair(item.image.first, null))
        navController?.navigate(R.id.viewerFragment, bundleOf("mod" to newItem))
    }

    fun navigateUp() {
        val navController = activityProvider.activeActivity
            ?.findNavController(R.id.fragmentContainer)
        navController?.navigateUp()
    }

    fun navigateToPlayMarket(applicationPackage: String) {
        val activity = activityProvider.activeActivity
        try {
            activity?.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$applicationPackage")
                )
            )
        } catch (e: ActivityNotFoundException) {
            activity?.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$applicationPackage")
                )
            )
        }
    }
}