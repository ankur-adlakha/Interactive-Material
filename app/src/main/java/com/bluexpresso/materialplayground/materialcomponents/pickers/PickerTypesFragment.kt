package com.bluexpresso.materialplayground.materialcomponents.pickers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentPickerTypesBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PickerTypesFragment : Fragment() {
    lateinit var pickerType: String

    companion object {
        private const val ARG_PICKER_TYPE = "picker_type"
        fun newInstance(dialogType: String) = PickerTypesFragment().also {
            val args = Bundle()
            args.putString(ARG_PICKER_TYPE, dialogType)
            it.arguments = args
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPickerTypesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_picker_types, container, false
        )
        extractArguments()
        initButton(binding.showPicker)
        return binding.root
    }

    private fun
            extractArguments() {
        pickerType = arguments!!.getString(ARG_PICKER_TYPE, getString(R.string.date))
    }

    private fun initButton(showDialog: MaterialButton) {
        when (pickerType) {
            getString(R.string.date) -> {
                showDialog.text = getString(R.string.show_date_picker)
            }
            getString(R.string.time) -> {
                showDialog.text = getString(R.string.show_time_picker)
            }
        }
        showDialog.setOnClickListener {
            getDialog()
        }
    }

    private fun getDialog() {
        when (pickerType) {
            getString(R.string.date) -> {

            }
            getString(R.string.time) -> {
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