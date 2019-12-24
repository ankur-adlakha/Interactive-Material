package com.bluexpresso.materialplayground.materialcomponents.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentDialogTypesBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

class DialogTypesFragment : Fragment() {
    lateinit var dialogInUse: MaterialDialogs
    lateinit var dialogType: String

    companion object {
        private const val ARG_DIALOG_TYPE = "dialog_type"
        fun newInstance(dialogType: String) = DialogTypesFragment().also {
            val args = Bundle()
            args.putString(ARG_DIALOG_TYPE, dialogType)
            it.arguments = args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDialogTypesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dialog_types, container, false
        )
        extractArguments()
        initButton(binding.showDialog)
        return binding.root
    }

    private fun extractArguments() {
        dialogType = arguments!!.getString(ARG_DIALOG_TYPE, getString(R.string.alert_dialog))
    }

    private fun initButton(showDialog: MaterialButton) {
        when (dialogType) {
            getString(R.string.alert_dialog) -> {
                showDialog.text = getString(R.string.show_alert_dialog)
            }
            getString(R.string.simple_dialog) -> {
                showDialog.text = getString(R.string.show_simple_dialog)
            }
            getString(R.string.confirmation_dialog) -> {
                showDialog.text = getString(R.string.show_confirmation_dialog)
            }
        }
        showDialog.setOnClickListener {
            getDialog()
        }
    }

    private fun getDialog() {
        when (dialogType) {
            getString(R.string.alert_dialog) -> {
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.alert_dialog)
                    .setMessage("This is an alert dialog")
                    .setPositiveButton("Ok", null)
                    .setNegativeButton("Close", null)
                    .show()
            }
            getString(R.string.simple_dialog) -> {
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.simple_dialog)
                        .setItems(
                    arrayOf("Item 1", "Item 2", "Item 4", "Item 3")
                ) { _, _ ->
                }.create().show()
            }
            getString(R.string.confirmation_dialog) -> {
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.confirmation_dialog)
                    .setSingleChoiceItems(
                        arrayOf("Item 1", "Item 2", "Item 3", "Item 4"),
                        -1
                    ) { _, _ -> }
                    .setPositiveButton("Ok", null)
                    .setNegativeButton("Close", null)
                    .setNeutralButton("Remind me later", null)
                    .create().show()
            }
        }
    }
}