package com.bluexpresso.materialplayground.materialcomponents.pickers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentPickersBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class PickersFragment : Fragment() {
    companion object {
        fun newInstance() =
            PickersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_pickers,
            container, false
        ) as FragmentPickersBinding
        initToolbar(binding.toolbar)
        initPickers(binding)
        return binding.root
    }

    private fun initPickers(binding: FragmentPickersBinding) {
        val fragmentActivity = activity
        if (fragmentActivity != null)
            binding.pickersViewPager.adapter = PickersFragmentAdapter(fragmentActivity)
        binding.pickersTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.pickersViewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.pickersViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.pickersTab.selectTab(binding.pickersTab.getTabAt(position))
            }
        })
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}