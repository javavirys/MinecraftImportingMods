package com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Mod
import com.javavirys.minecraftmod.domain.repository.ImportModRepository
import com.javavirys.minecraftmod.domain.repository.ModRepository
import com.javavirys.minecraftmod.presentation.entity.DownloadButtonState
import com.javavirys.minecraftmod.presentation.navigation.MainRouter
import kotlinx.coroutines.delay

class ViewerViewModel(
    private val router: MainRouter,
    private val importModRepository: ImportModRepository,
    private val databaseModRepository: ModRepository
) : BaseViewModel() {

    val downloadButtonLiveData = MutableLiveData<DownloadButtonState>().also {
        it.value = DownloadButtonState.STATE_DOWNLOAD
    }

    val favoriteLiveData = MutableLiveData<Boolean>()

    fun setMod(mod: Mod) {
        launch(
            backgroundCode = { databaseModRepository.getModByAddonName(mod.addonName) },
            foregroundCode = { favoriteLiveData.value = it.javavirysfavorite },
            catchCode = { favoriteLiveData.value = false }
        )
    }

    fun javavirysnavigateUp() {
        router.javavirysnavigateUp()
    }

    fun installMod(mod: Mod) {
        when (downloadButtonLiveData.value) {
            DownloadButtonState.STATE_DOWNLOAD -> {
                launch(
                    backgroundCode = {
                        downloadButtonLiveData.postValue(DownloadButtonState.STATE_DOWNLOADING)
                        delay(2000)
                    },
                    foregroundCode = {
                        downloadButtonLiveData.value = DownloadButtonState.STATE_INSTALL
                    }
                )
            }
            DownloadButtonState.STATE_INSTALL -> {
                launch(
                    backgroundCode = { importModRepository.importMod(mod) },
                    foregroundCode = {
                        downloadButtonLiveData.value = DownloadButtonState.STATE_INSTALLED
                        updateStatus()
                    }
                )
            }
            DownloadButtonState.STATE_INSTALLED -> Unit
            else -> Unit
        }
    }

    fun navigateToPlayMarket() {
        router.navigateToPlayMarket(MINECRAFT_PACKAGE)
    }

    fun selectItem(item: Mod) {
        item.javavirysfavorite = !item.javavirysfavorite
        favoriteLiveData.value = item.javavirysfavorite
        if (item.javavirysfavorite) {
            launch(
                backgroundCode = { databaseModRepository.addMod(item) }
            )
        } else {
            launch(
                backgroundCode = { databaseModRepository.removeMod(item) }
            )
        }
    }

    fun updateStatus() {
        launch(
            backgroundCode = {
                delay(1000)
            },
            foregroundCode = {
                downloadButtonLiveData.value = DownloadButtonState.STATE_DOWNLOAD
            }
        )
    }

    companion object {
        const val MINECRAFT_PACKAGE = "com.mojang.minecraftpe"
    }
}