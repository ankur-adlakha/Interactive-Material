package com.bluexpresso.materialplayground.materialcomponents.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentButtonTypesBinding
import com.google.android.material.button.MaterialButton

class ButtonTypesFragment : Fragment() {
    lateinit var buttonInUse: MaterialButton

    companion object {
        private const val ARG_BUTTON_TYPE = "button_type"
        fun newInstance(buttonType: String): ButtonTypesFragment {
            return ButtonTypesFragment().apply {
                val args = Bundle()
                args.putString(ARG_BUTTON_TYPE, buttonType)
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
            inflater, R.layout.fragment_button_types,
            container, false
        ) as FragmentButtonTypesBinding
        initButton(binding)
        initIconGravity(binding)
        initShowHideIcon(binding)
        initStrokeWidth(binding)
        initCornerRadius(binding)
        return binding.root
    }

    private fun initCornerRadius(binding: FragmentButtonTypesBinding) {
        binding.cornerRadiusSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                buttonInUse.cornerRadius = progress
                binding.cornerRadiusSeekBarValue.text = "$progress"
            }
        })
        binding.cornerRadiusSeekBar.progress = 10
    }

    private fun initStrokeWidth(binding: FragmentButtonTypesBinding) {
        binding.strokeWidthSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                buttonInUse.strokeWidth = progress
                binding.strokeWidthSeekBarValue.text = "$progress"
            }
        })
        binding.strokeWidthSeekBar.progress = 10
    }

    private fun initShowHideIcon(binding: FragmentButtonTypesBinding) {
        binding.switchIcon.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                buttonInUse.setIconResource(R.drawable.ic_arrow_forward_white_24dp)
                buttonInUse.iconGravity = getIconGravity(binding)
            } else {
                buttonInUse.setIconResource(0)
            }
        }
    }

    private fun initIconGravity(binding: FragmentButtonTypesBinding) {
        binding.rgIconGravity.setOnCheckedChangeListener { _, _ ->
            if (binding.rgIconGravity.checkedRadioButtonId == R.id.rb_icon_start) {
                buttonInUse.iconGravity = MaterialButton.ICON_GRAVITY_START
            } else {
                buttonInUse.iconGravity = MaterialButton.ICON_GRAVITY_END
            }
        }
    }

    fun getIconGravity(binding: FragmentButtonTypesBinding) =
        if (binding.rbIconStart.isChecked) MaterialButton.ICON_GRAVITY_START
        else MaterialButton.ICON_GRAVITY_END

    private fun initButton(binding: FragmentButtonTypesBinding) {
        val buttonType = arguments!!.getString(ARG_BUTTON_TYPE, "")
        when {
            buttonType.equals(getString(R.string.outlined_button), true) -> {
                buttonInUse = binding.outlinedButton
                binding.outlinedButton.visibility = View.VISIBLE
                binding.unelevatedButton.visibility = View.GONE
                binding.textButton.visibility = View.GONE
            }
            buttonType.equals(getString(R.string.unelevated_button), true) -> {
                buttonInUse = binding.unelevatedButton
                binding.outlinedButton.visibility = View.GONE
                binding.unelevatedButton.visibility = View.VISIBLE
                binding.textButton.visibility = View.GONE
            }
            buttonType.equals(getString(R.string.text_button), true) -> {
                buttonInUse = binding.textButton
                binding.outlinedButton.visibility = View.GONE
                binding.unelevatedButton.visibility = View.GONE
                binding.textButton.visibility = View.VISIBLE
            }
        }
    }
}