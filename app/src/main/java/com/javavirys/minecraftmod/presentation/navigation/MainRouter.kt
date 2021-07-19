package com.javavirys.minecraftmod.presentation.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.javavirys.minecraftmod.ActivityProvider
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
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
        val javavirysnewItem = item.copy(image = null)
        navController?.navigate(R.id.viewerFragment, bundleOf("mod" to javavirysnewItem))
    }

    fun javavirysnavigateUp() {
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