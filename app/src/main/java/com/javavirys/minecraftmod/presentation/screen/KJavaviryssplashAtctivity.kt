package com.javavirys.minecraftmod.presentation.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity.Result
import com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds.SplashViewModel
import com.javavirys.minecraftmod.util.extension.findView
import org.koin.androidx.viewmodel.ext.android.viewModel

class KJavaviryssplashAtctivity : AppCompatActivity(R.layout.javavirysactivity_huysppizdaalash) {

    private val model: SplashViewModel by viewModel()

    private val linearProgressIndicator by lazy { findView<LinearProgressIndicator>(R.id.linearProgressIndicator) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION }

        model.loadingLiveData.observe(this) {
            when (it) {
                is Result.Progress -> linearProgressIndicator.progress = it.progress
                is Result.Javaviryssuccelss -> {
                    model.navigateToMainScreen()
                    finish()
                }
                is Result.Error -> throw UnsupportedOperationException()
            }
        }

        model.load()
    }
}