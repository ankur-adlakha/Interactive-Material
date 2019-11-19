package com.bluexpresso.materialplayground.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentButtonsBinding
import com.google.android.material.appbar.MaterialToolbar

class ButtonsFragment : Fragment() {
    companion object {
        fun newInstance() = ButtonsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_buttons,
            container, false
        ) as FragmentButtonsBinding
        initToolbar(binding.toolbar)
        return binding.root
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}