package com.bluexpresso.materialplayground.materialcomponents.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentCardsBinding
import com.google.android.material.appbar.MaterialToolbar

class CardsFragment : Fragment() {
    companion object {
        fun newInstance() = CardsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cards,
            container, false
        ) as FragmentCardsBinding
        initCardElevation(binding)
        initCardCornerRadius(binding)
        initCardStrokeWidth(binding)
        initToolbar(binding.toolbar)
        return binding.root
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }

    private fun initCardStrokeWidth(binding: FragmentCardsBinding) {
        binding.cardViewStrokeWidthSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.cardViewStrokeWidthValue.text = "$p1"
                binding.cardView.strokeWidth = p1
            }

        })
    }

    private fun initCardCornerRadius(binding: FragmentCardsBinding) {
        binding.cardViewCornerRadiusSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.cardViewCornerRadiusValue.text = "$p1"
                binding.cardView.radius = p1.toFloat()
            }

        })
    }

    private fun initCardElevation(binding: FragmentCardsBinding) {
        binding.cardViewElevationSeekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.cardViewElevationValue.text = "$p1"
                binding.cardView.cardElevation = p1.toFloat()
            }

        })
    }
}