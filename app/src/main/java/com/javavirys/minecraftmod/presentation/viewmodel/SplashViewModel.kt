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