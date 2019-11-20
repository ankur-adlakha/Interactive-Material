package com.bluexpresso.materialplayground.materialcomponents.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentButtonsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class ButtonsFragment : Fragment() {
    companion object {
        fun newInstance() =
            ButtonsFragment()
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
        initButtonsViewPager(binding)
        return binding.root
    }

    private fun initButtonsViewPager(binding: FragmentButtonsBinding) {
        val fragmentActivity = activity
        if (fragmentActivity != null)
            binding.buttonsViewPager.adapter = ButtonsFragmentAdapter(fragmentActivity)
        binding.buttonsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.buttonsViewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.buttonsViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.buttonsTab.selectTab(binding.buttonsTab.getTabAt(position))
            }
        })
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}