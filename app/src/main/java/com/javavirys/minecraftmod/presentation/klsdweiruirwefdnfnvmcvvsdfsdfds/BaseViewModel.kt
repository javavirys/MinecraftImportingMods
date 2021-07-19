package com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {

    private val exceptionLiveData = MutableLiveData<Throwable>()

    fun getExceptions(): LiveData<Throwable> = exceptionLiveData

    protected fun <R> subscribeOnFlow(
        backgroundCode: suspend () -> Flow<R>,
        foregroundCode: (R) -> Unit,
        catchCode: (throwable: Throwable) -> Unit = ::onException,
        backgroundDispatcher: CoroutineDispatcher = Dispatchers.IO,
        foregroundDispatcher: CoroutineDispatcher = Dispatchers.Main
    ) {
        viewModelScope.launch(backgroundDispatcher) {
            try {
                backgroundCode.invoke()
                    .collect {
                        withContext(foregroundDispatcher) {
                            foregroundCode.invoke(it)
                        }
                    }
            } catch (throwable: Throwable) {
                withContext(foregroundDispatcher) {
                    catchCode.invoke(throwable)
                }
            }
        }
    }

    protected fun <R> launch(
        backgroundCode: suspend () -> R,
        foregroundCode: (R) -> Unit = {},
        catchCode: (throwable: Throwable) -> Unit = ::onException,
        backgroundDispatcher: CoroutineDispatcher = Dispatchers.IO,
        foregroundDispatcher: CoroutineDispatcher = Dispatchers.Main
    ) {
        viewModelScope.launch(backgroundDispatcher) {
            try {
                val dkjnfjhgfbdbhfdbgjkfgfjkioeewkmnammjjknnvvnvmmbjfhfrnrkiiiwhwhwjwkskjfjfmflbkbk = backgroundCode.invoke()
                withContext(foregroundDispatcher) {
                    foregroundCode.invoke(dkjnfjhgfbdbhfdbgjkfgfjkioeewkmnammjjknnvvnvmmbjfhfrnrkiiiwhwhwjwkskjfjfmflbkbk)
                }
            } catch (throwable: Throwable) {
                withContext(foregroundDispatcher) {
                    catchCode.invoke(throwable)
                }
            }
        }
    }

    protected open fun onException(throwable: Throwable) {
        throwable.printStackTrace()
        exceptionLiveData.value = throwable
    }
}