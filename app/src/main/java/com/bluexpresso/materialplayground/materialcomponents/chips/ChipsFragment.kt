package com.bluexpresso.materialplayground.materialcomponents.chips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentChipsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class ChipsFragment : Fragment() {
    companion object {
        fun newInstance() =
            ChipsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_chips,
            container, false
        ) as FragmentChipsBinding
        initToolbar(binding.toolbar)
        initButtonsViewPager(binding)
        return binding.root
    }

    private fun initButtonsViewPager(binding: FragmentChipsBinding) {
        val fragmentActivity = activity
        if (fragmentActivity != null)
            binding.chipsViewPager.adapter = ChipsFragmentAdapter(fragmentActivity)
        binding.chipsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.chipsViewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.chipsViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.chipsTab.selectTab(binding.chipsTab.getTabAt(position))
            }
        })
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}