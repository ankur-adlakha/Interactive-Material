package com.bluexpresso.materialplayground.materialcomponents.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentDialogsBinding
import com.bluexpresso.materialplayground.materialcomponents.buttons.ButtonsFragment
import com.bluexpresso.materialplayground.materialcomponents.buttons.ButtonsFragmentAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class DialogsFragment : Fragment() {
    companion object {
        fun newInstance() =
            DialogsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dialogs,
            container, false
        ) as FragmentDialogsBinding
        initToolbar(binding.toolbar)
        initButtonsViewPager(binding)
        return binding.root
    }

    private fun initButtonsViewPager(binding: FragmentDialogsBinding) {
        val fragmentActivity = activity
        if (fragmentActivity != null)
            binding.dialogsViewPager.adapter = DialogsFragmentAdapter(fragmentActivity)
        binding.dialogsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.dialogsViewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        binding.dialogsViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.dialogsTab.selectTab(binding.dialogsTab.getTabAt(position))
            }
        })
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}