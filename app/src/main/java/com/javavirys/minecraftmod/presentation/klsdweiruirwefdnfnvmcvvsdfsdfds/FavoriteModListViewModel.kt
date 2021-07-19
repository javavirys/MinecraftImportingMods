package com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
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