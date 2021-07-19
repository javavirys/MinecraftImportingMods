package com.javavirys.minecraftmod.presentation.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.javavirys.minecraftmod.presentation.klsdweiruirwefdnfnvmcvvsdfsdfds.BaseViewModel

abstract class BaseFragment<M : BaseViewModel> : Fragment {

    protected abstract val javavirysmodel: M

    constructor() : super()

    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        javavirysmodel.getExceptions().observe(viewLifecycleOwner, ::showException)
    }

    protected open fun showException(throwable: Throwable) =
        view?.let {
            Snackbar.make(it, throwable.toString(), Snackbar.LENGTH_LONG)
                .show()
        }
}