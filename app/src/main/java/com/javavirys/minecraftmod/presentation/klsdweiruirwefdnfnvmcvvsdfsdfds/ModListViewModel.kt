package com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.domain.repository.ModRepository
import com.javavirys.minecraftmod.presentation.navigation.MainRouter

class ModListViewModel(
    private val router: MainRouter,
    private val assetsModRepository: ModRepository,
    private val databaseModRepository: ModRepository
) : BaseViewModel() {

    val modsLiveData = MutableLiveData<List<Mod>>()

    val favoriteLiveData = MutableLiveData<Mod>()

    fun loadMods() {
        subscribeOnFlow(
            backgroundCode = { assetsModRepository.getAll() },
            foregroundCode = {
                modsLiveData.value = it
            }
        )
    }

    fun observeDatabase() {
        subscribeOnFlow(
            backgroundCode = { databaseModRepository.getAll() },
            foregroundCode = {
                it.forEach { item ->
                    favoriteLiveData.value = item
                }
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

    fun navigateToFavoriteScreen() {
        router.navigateToFavoriteScreen()
    }

    fun navigateToModViewer(item: Mod) {
        router.navigateToViewerScreen(item)
    }
}