package com.bluexpresso.materialplayground.materialcomponents.chips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentChipTypesBinding
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.snackbar.Snackbar

class ChipTypesFragment : Fragment() {
    var isChipGroup = false

    companion object {
        private const val ARG_CHIP_TYPE = "chip_type"
        fun newInstance(chipType: String): ChipTypesFragment {
            return ChipTypesFragment().apply {
                val args = Bundle()
                args.putString(ARG_CHIP_TYPE, chipType)
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
            inflater, R.layout.fragment_chip_types,
            container, false
        ) as FragmentChipTypesBinding
        initChip(binding)
        initShowHideIcon(binding)
        initStrokeWidth(binding)
        initCornerRadius(binding)
        initChipGroup(binding)
        if (isChipGroup) {
            binding.switchChipCloseIcon.isChecked = false
            binding.showHideChipIcon.isEnabled = false
            binding.switchChipIcon.isEnabled = false
            binding.switchChipIcon.isChecked = false
            binding.chipDescription.text = getString(R.string.chip_filter_description)
        } else {
            binding.chipDescription.text = getString(R.string.entry_chip_description)
        }
        return binding.root
    }

    private fun initChipGroup(binding: FragmentChipTypesBinding) {
        binding.chipFilterGroup.setOnCheckedChangeListener { _, checkedId ->
            Snackbar.make(
                binding.root,
                if (checkedId == R.id.chip_filter_one) {
                    "Chip One checked"
                } else {
                    "Chip Two checked"
                }, Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun initCornerRadius(binding: FragmentChipTypesBinding) {
        val shapeAppearanceBuilder = ShapeAppearanceModel.builder()
        binding.cornerRadiusSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                shapeAppearanceBuilder.setAllCornerSizes(progress.toFloat())
                if (isChipGroup) {
                    binding.chipFilterOne.shapeAppearanceModel = shapeAppearanceBuilder.build()
                    binding.chipFilterTwo.shapeAppearanceModel = shapeAppearanceBuilder.build()
                } else {
                    binding.entryChip.shapeAppearanceModel = shapeAppearanceBuilder.build()
                }
                binding.cornerRadiusSeekBarValue.text = "$progress"
            }
        })
        binding.cornerRadiusSeekBar.progress = 10
    }

    private fun initStrokeWidth(binding: FragmentChipTypesBinding) {
        binding.strokeWidthSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                if (isChipGroup) {
                    binding.chipFilterOne.chipStrokeWidth = progress.toFloat()
                    binding.chipFilterTwo.chipStrokeWidth = progress.toFloat()
                } else {
                    binding.entryChip.chipStrokeWidth = progress.toFloat()
                }
                binding.strokeWidthSeekBarValue.text = "$progress"
            }
        })
        binding.strokeWidthSeekBar.progress = 1
    }

    private fun initShowHideIcon(binding: FragmentChipTypesBinding) {
        binding.switchChipIcon.setOnCheckedChangeListener { _, isChecked ->
            if (isChipGroup) {
                binding.chipFilterOne.isChipIconVisible = isChecked
                binding.chipFilterTwo.isChipIconVisible = isChecked
            } else {
                binding.entryChip.isChipIconVisible = isChecked
            }
        }
        binding.switchChipCloseIcon.setOnCheckedChangeListener { _, isChecked ->
            if (isChipGroup) {
                binding.chipFilterOne.isCloseIconVisible = isChecked
                binding.chipFilterTwo.isCloseIconVisible = isChecked
            } else {
                binding.entryChip.isCloseIconVisible = isChecked
            }
        }
        binding.entryChip.setOnCloseIconClickListener {
            Snackbar.make(binding.root, "On close icon click", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun initChip(binding: FragmentChipTypesBinding) {
        val chipType = arguments!!.getString(ARG_CHIP_TYPE, "")
        when {
            chipType.equals(getString(R.string.entry_chip), true) -> {
                isChipGroup = false
                binding.entryChip.visibility = View.VISIBLE
                binding.chipFilterGroup.visibility = GONE
            }
            chipType.equals(getString(R.string.filter_chip), true) -> {
                isChipGroup = true
                binding.entryChip.visibility = GONE
                binding.chipFilterGroup.visibility = View.VISIBLE
            }
        }
    }
}