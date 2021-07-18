package com.javavirys.minecraftmod.presentation.screen

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.presentation.entity.DownloadButtonState
import com.javavirys.minecraftmod.presentation.viewmodel.ViewerViewModel
import com.javavirys.minecraftmod.presentation.viewmodel.ViewerViewModel.Companion.MINECRAFT_PACKAGE
import com.javavirys.minecraftmod.util.extension.findView
import com.javavirys.minecraftmod.util.extension.isPackageInstalled
import com.javavirys.minecraftmod.util.extension.loadBitmapFromAssets
import com.javavirys.minecraftmod.util.extension.setTextColorCompat
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewerFragment : BaseFragment<ViewerViewModel>(R.layout.fragment_viewer) {

    private val args: ViewerFragmentArgs by navArgs()

    override val model: ViewerViewModel by viewModel()

    private val modsButton by lazy { requireActivity().findView<View>(R.id.modsView) }

    private val modsTitle by lazy { requireActivity().findView<TextView>(R.id.modsTextView) }

    private val favoriteButton by lazy { requireActivity().findView<View>(R.id.favoriteView) }

    private val favoriteTitle by lazy { requireActivity().findView<TextView>(R.id.favoriteTextView) }

    private lateinit var downloadButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.setMod(args.mod)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()

        downloadButton = view.findView(R.id.downloadButton)

        val logoImageView = view.findView<ImageView>(R.id.logoImageView)
        val star = view.findView<ImageView>(R.id.star)
        val titleTextView = view.findView<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findView<TextView>(R.id.descriptionTextView)

        view.findView<ImageView>(R.id.close).setOnClickListener { model.navigateUp() }
        view.findView<ImageView>(R.id.triangle).setOnClickListener {
            model.selectItem(args.mod)
        }

        downloadButton.setOnClickListener {
            checkPermissions {
                if (requireContext().packageManager.isPackageInstalled(MINECRAFT_PACKAGE)) {
                    installMod(args.mod)
                } else {
                    if (model.downloadButtonLiveData.value == DownloadButtonState.STATE_INSTALL) {
                        model.navigateToPlayMarket()
                        model.updateStatus()
                    } else {
                        installMod(args.mod)
                    }
                }
            }
        }

        model.downloadButtonLiveData.observe(viewLifecycleOwner) {
            when (it) {
                DownloadButtonState.STATE_DOWNLOAD -> {
                    downloadButton.isEnabled = true
                    downloadButton.text = getString(R.string.fragment_viewer_download)
                }
                DownloadButtonState.STATE_DOWNLOADING -> {
                    downloadButton.text = getString(R.string.fragment_viewer_downloading)
                }
                DownloadButtonState.STATE_INSTALL -> {
                    downloadButton.text = getString(R.string.fragment_viewer_install)
                }
                DownloadButtonState.STATE_INSTALLED -> {
                    downloadButton.text = getString(R.string.fragment_viewer_installed)
                    downloadButton.isEnabled = false
                }
                else -> throw UnsupportedOperationException()
            }
        }

        Glide.with(this)
            .load(requireContext().loadBitmapFromAssets("images/${args.mod.imagePath}"))
            .into(logoImageView)

        titleTextView.text = args.mod.name
        descriptionTextView.text = args.mod.description
        checkPermissions()
        model.favoriteLiveData.observe(viewLifecycleOwner) {
            val starImage = if (it) {
                R.drawable.ic_star_selected
            } else {
                R.drawable.ic_star_unselected
            }

            Glide.with(this)
                .load(starImage)
                .into(star)
        }
    }

    private fun installMod(mod: Mod) {
        model.installMod(mod)
    }

    private fun initTabs() {
        modsButton.setBackgroundResource(R.drawable.tab_unchecked)
        favoriteButton.setBackgroundResource(R.drawable.tab_unchecked)
        modsTitle.setTextColorCompat(R.color.white_50)
        favoriteTitle.setTextColorCompat(R.color.white_50)
        modsButton.setOnClickListener(null)
        favoriteButton.setOnClickListener(null)
    }

    private fun checkPermissions(afterCheck: () -> Unit = {}) {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            afterCheck()
        } else {
            requestPermission(afterCheck)
        }
    }

    private fun requestPermission(afterCheck: () -> Unit) {
        val requestPermissionLauncher =
            registerForActivityResult(RequestMultiplePermissions()) { map ->
                val count = map.values.filter { it == true }.size
                if (count == map.values.size) {
                    afterCheck()
                } else {
                    Toast.makeText(
                        requireContext(),
                        R.string.fragment_viewer_permission_denied,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        requestPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )
    }
}