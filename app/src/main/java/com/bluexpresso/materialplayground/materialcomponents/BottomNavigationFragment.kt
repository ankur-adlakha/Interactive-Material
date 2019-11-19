package com.bluexpresso.materialplayground.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bluexpresso.materialplayground.R
import com.bluexpresso.materialplayground.databinding.FragmentBottomNavigationBinding
import com.bluexpresso.materialplayground.materialcomponents.DummyScrollingListAdapter.Companion.ITEM_TYPE_CARD
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior

class BottomNavigationFragment : Fragment() {
    companion object {
        fun newInstance() = BottomNavigationFragment()
    }

    private lateinit var hideBottomViewOnScrollBehavior: HideBottomViewOnScrollBehavior<View>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_bottom_navigation,
                container, false
            ) as FragmentBottomNavigationBinding
        initToolbar(binding.toolbar)
        initDummyGridScrollingContent(binding)
        initBottomNavMenuItems(binding)
        initHideBottomNavOnScroll(binding)
        return binding.root
    }

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }

    private fun initHideBottomNavOnScroll(binding: FragmentBottomNavigationBinding) {
        val params = getBottomNavLayoutParams(binding)
        hideBottomViewOnScrollBehavior = params.behavior as HideBottomViewOnScrollBehavior<View>
        binding.hideBottomNav.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                params.behavior = hideBottomViewOnScrollBehavior
            } else {
                params.behavior = null
            }
            binding.bottomNavView.layoutParams = params
        }
    }

    fun getBottomNavLayoutParams(binding: FragmentBottomNavigationBinding) =
        binding.bottomNavView.layoutParams as CoordinatorLayout.LayoutParams

    private fun initBottomNavMenuItems(binding: FragmentBottomNavigationBinding) {
        binding.bottomNavMenuItemsRg.setOnCheckedChangeListener { radioGroup, i ->
            if (radioGroup.checkedRadioButtonId == R.id.bottom_nav_menu_items_3) {
                binding.bottomNavView.menu.clear()
                binding.bottomNavView.inflateMenu(R.menu.bottom_nav_menu_three)

            } else if (radioGroup.checkedRadioButtonId == R.id.bottom_nav_menu_items_5) {
                binding.bottomNavView.menu.clear()
                binding.bottomNavView.inflateMenu(R.menu.bottom_nav_menu_five)
            }
        }
    }

    private fun initDummyGridScrollingContent(binding: FragmentBottomNavigationBinding) {
        binding.dummyScrollingContent.adapter = DummyScrollingListAdapter(ITEM_TYPE_CARD)
        (binding.dummyScrollingContent.layoutManager as StaggeredGridLayoutManager)
            .apply {
                spanCount = 1
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
    }
}