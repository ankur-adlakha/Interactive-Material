package com.bluexpresso.materialplayground.materialcomponents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluexpresso.materialplayground.databinding.ItemDummyListBinding

class DummyScrollingListAdapter : RecyclerView.Adapter<DummyScrollingListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DummyScrollingListViewHolder {
        return DummyScrollingListViewHolder(
            ItemDummyListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = 100

    override fun onBindViewHolder(holder: DummyScrollingListViewHolder, position: Int) {
    }

}

class DummyScrollingListViewHolder(val itemDummyListBinding: ItemDummyListBinding) :
    RecyclerView.ViewHolder(itemDummyListBinding.root) {

}