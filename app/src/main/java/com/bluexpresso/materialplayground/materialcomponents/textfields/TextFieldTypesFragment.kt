package com.bluexpresso.materialplayground.materialcomponents.textfields

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentButtonTypesBinding
import com.bluexpresso.materialplayground.databinding.FragmentTextFieldTypesBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class TextFieldTypesFragment : Fragment() {
    lateinit var textFieldInUse: TextInputLayout

    companion object {
        private const val TEXT_FIELD_TYPE = "text_field_type"
        fun newInstance(textFieldType: String): TextFieldTypesFragment {
            return TextFieldTypesFragment().apply {
                val args = Bundle()
                args.putString(TEXT_FIELD_TYPE, textFieldType)
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_text_field_types,
            container, false
        ) as FragmentTextFieldTypesBinding
        initTextInput(binding)
        initLeadingIcon(binding)
        initTrailingIcon(binding)
        initCharacterCount(binding)
        initCornerRadius(binding)
        return binding.root
    }

    private fun initCharacterCount(binding: FragmentTextFieldTypesBinding) {
        textFieldInUse.counterMaxLength = 20
        binding.switchCharacterCount.setOnCheckedChangeListener { _, isChecked ->
            textFieldInUse.isCounterEnabled = isChecked
        }
    }

    private fun initTrailingIcon(binding: FragmentTextFieldTypesBinding) {
        textFieldInUse.setEndIconDrawable(R.drawable.ic_remove_red_eye_black_24dp)
        textFieldInUse.setEndIconOnClickListener {
            Snackbar.make(binding.root, "End icon clicked", Snackbar.LENGTH_SHORT).show()
        }
        binding.switchTrailingIcon.setOnCheckedChangeListener { _, isChecked ->
            textFieldInUse.isEndIconVisible = isChecked
            textFieldInUse.setEndIconActivated(isChecked)
        }
    }

    private fun initLeadingIcon(binding: FragmentTextFieldTypesBinding) {
        textFieldInUse.startIconDrawable = ContextCompat.getDrawable(
            textFieldInUse.context, R.drawable.ic_person_black_24dp
        )
        textFieldInUse.setStartIconOnClickListener {
            Snackbar.make(binding.root, "Start icon clicked", Snackbar.LENGTH_SHORT).show()
        }
        binding.switchLeadingIcon.setOnCheckedChangeListener { _, isChecked ->
            textFieldInUse.isStartIconVisible = isChecked
        }
    }

    private fun initCornerRadius(binding: FragmentTextFieldTypesBinding) {
        binding.cornerRadiusSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                textFieldInUse.setBoxCornerRadii(
                    progress.toFloat(), progress.toFloat(),
                    progress.toFloat(), progress.toFloat()
                )
                binding.cornerRadiusSeekBarValue.text = "$progress"
            }
        })
        binding.cornerRadiusSeekBar.progress = 10
    }

    private fun initTextInput(binding: FragmentTextFieldTypesBinding) {
        val textFieldType = arguments!!.getString(TEXT_FIELD_TYPE, "")
        when {
            textFieldType.equals(getString(R.string.textinput_filled), true) -> {
                textFieldInUse = binding.textInputLayoutFilled
                binding.textInputLayoutFilled.visibility = View.VISIBLE
                binding.textInputLayoutOutlined.visibility = View.GONE
            }
            textFieldType.equals(getString(R.string.textinput_outlined), true) -> {
                textFieldInUse = binding.textInputLayoutOutlined
                binding.textInputLayoutFilled.visibility = View.GONE
                binding.textInputLayoutOutlined.visibility = View.VISIBLE
            }
        }
    }
}