package com.bluexpresso.materialplayground.materialcomponents.pickers

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluexpresso.materialplayground.R

class PickersFragmentAdapter(var fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        when (position) {
            0 -> PickerTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.date
                )
            )
            1 -> PickerTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.time
                )
            )
            else -> PickerTypesFragment.newInstance(
                fragmentActivity.getString(
                    R.string.time
                )
            )
        }
}