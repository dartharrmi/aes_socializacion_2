@file:Suppress("DEPRECATION")

package com.dartharrmi.aes.pas.borboapp.presentation.dialogs

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

/**
 * Loading dialog.
 *
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
class LoadingDialog : DialogFragment() {

    companion object {
        const val FRAGMENT_TAG = "LOADING_DIALOG"
        const val KEY_LABEL = "KEY_LABEL"

        fun newInstance(arguments: Bundle): LoadingDialog {
            val loadingFragment = LoadingDialog()
            loadingFragment.arguments = arguments

            return loadingFragment
        }
    }

    private lateinit var mLabel: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when {
            savedInstanceState != null -> {
                mLabel = savedInstanceState.getString(KEY_LABEL)
            }

            arguments != null -> {
                mLabel = arguments?.getString(KEY_LABEL) as String
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val progressDialog = ProgressDialog(activity, theme)
        progressDialog.setMessage(mLabel)
        progressDialog.isIndeterminate = true
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        return progressDialog
    }
}