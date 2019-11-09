package com.bluexpresso.materialplayground.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentAppBarsBottomBinding
import com.google.android.material.bottomappbar.BottomAppBar

class BottomAppBarsFragment : Fragment() {
    companion object {
        fun newInstance() =
            BottomAppBarsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_app_bars_bottom,
            container, false
        ) as FragmentAppBarsBottomBinding
        initBottomAppBar(binding)
        initShowHideFab(binding)
        initAlignmentMode(binding)
        initCradleMargin(binding)
        initCradleCornerRadius(binding)
        initCradleVerticalOffset(binding)
        return binding.root
    }

    private fun initBottomAppBar(binding: FragmentAppBarsBottomBinding) {
        binding.bottomAppBar.setNavigationOnClickListener {
            activity?.finish()
        }
    }

    private fun initCradleVerticalOffset(binding: FragmentAppBarsBottomBinding) {
        binding.fabCradleVerticalOffsetSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.bottomAppBar.cradleVerticalOffset = p1.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    private fun initCradleCornerRadius(binding: FragmentAppBarsBottomBinding) {
        binding.fabCradleCornerRadiusSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.bottomAppBar.fabCradleRoundedCornerRadius = p1.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    private fun initCradleMargin(binding: FragmentAppBarsBottomBinding) {
        binding.fabCradleMarginSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.bottomAppBar.fabCradleMargin = p1.toFloat()
            }

        })
    }

    private fun initAlignmentMode(binding: FragmentAppBarsBottomBinding) {
        binding.fabAlignementModeRadioGroup.setOnCheckedChangeListener { radioGroup, _ ->
            if (radioGroup.checkedRadioButtonId == R.id.fab_alignement_center) {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            } else {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }

        }
    }

    private fun initShowHideFab(binding: FragmentAppBarsBottomBinding) {
        binding.fabVisibilitySwitch.setOnCheckedChangeListener { _, isChecked ->
            binding.fab.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

    }
}