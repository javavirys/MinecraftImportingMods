package com.javavirys.minecraftmod.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.javavirys.minecraftmod.core.entity.Result
import com.javavirys.minecraftmod.presentation.navigation.SplashRouter
import kotlinx.coroutines.delay

class SplashViewModel(
    private val router: SplashRouter
) : BaseViewModel() {

    val loadingLiveData = MutableLiveData<Result<Unit>>()

    fun navigateToMainScreen() {
        router.navigateToMainScreen()
    }

    fun load() {
        launch(
            backgroundCode = {
                loadingLiveData.postValue(Result.Progress(0))
                for (i in 1..100) {
                    delay(30)
                    loadingLiveData.postValue(Result.Progress(i))
                }
            },
            foregroundCode = {
                loadingLiveData.value = Result.Success(Unit)
            }
        )
    }
}