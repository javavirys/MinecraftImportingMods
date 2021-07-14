package com.javavirys.minecraftmod.presentation.screen

import android.os.Bundle
import android.view.View
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override val model: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreenMode()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setFullScreenMode()
    }

    private fun setFullScreenMode() {
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}