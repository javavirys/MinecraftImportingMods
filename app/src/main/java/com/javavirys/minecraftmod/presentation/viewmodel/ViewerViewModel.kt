package com.javavirys.minecraftmod.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.domain.repository.ImportModRepository
import com.javavirys.minecraftmod.presentation.entity.DownloadButtonState
import com.javavirys.minecraftmod.presentation.navigation.MainRouter
import kotlinx.coroutines.delay

class ViewerViewModel(
    private val router: MainRouter,
    private val importModRepository: ImportModRepository
) : BaseViewModel() {

    val downloadButtonLiveData = MutableLiveData<DownloadButtonState>().also {
        it.value = DownloadButtonState.STATE_DOWNLOAD
    }

    fun setMod(mod: Mod) {
        launch(
            backgroundCode = {
                importModRepository.isImportedMod(mod)
            },
            foregroundCode = { isImported ->
                if (isImported) {
                    downloadButtonLiveData.value = DownloadButtonState.STATE_INSTALLED
                } else {
                    downloadButtonLiveData.value = DownloadButtonState.STATE_DOWNLOAD
                }
            }
        )
    }

    fun navigateUp() {
        router.navigateUp()
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

    companion object {
        const val MINECRAFT_PACKAGE = "com.mojang.minecraftpe"
    }
}