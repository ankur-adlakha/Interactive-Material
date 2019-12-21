package com.bluexpresso.materialplayground.materialcomponents.textfields

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentTextfieldsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class TextFieldsFragment : Fragment() {
    companion object {
        fun newInstance() =
            TextFieldsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_textfields,
            container, false
        ) as FragmentTextfieldsBinding
        initToolbar(binding.toolbar)
        initTextFieldsViewPager(binding)
        return binding.root
    }

    private fun initTextFieldsViewPager(binding: FragmentTextfieldsBinding) {
        val fragmentActivity = activity
        if (fragmentActivity != null)
            binding.textFieldsViewPager.adapter = TextFieldsFragmentAdapter(fragmentActivity)
        binding.textFieldsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.textFieldsViewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.textFieldsViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.textFieldsTab.selectTab(binding.textFieldsTab.getTabAt(position))
            }
        })
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}