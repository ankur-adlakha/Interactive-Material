package com.bluexpresso.materialplayground.materialcomponents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluexpresso.materialplayground.databinding.ItemDummyGridCardBinding
import com.bluexpresso.materialplayground.databinding.ItemDummyListBinding

class DummyScrollingListAdapter(val itemTye: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_TYPE_LIST = 1
        const val ITEM_TYPE_CARD = 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == ITEM_TYPE_LIST) {
            return DummyScrollingListViewHolder(
                ItemDummyListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        } else {
            return DummyScrollingCardViewHolder(
                ItemDummyGridCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (itemTye == ITEM_TYPE_LIST)
            return ITEM_TYPE_LIST
        return ITEM_TYPE_CARD
    }

    override fun getItemCount() = if (itemTye == ITEM_TYPE_LIST) 100 else 20

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

}

class DummyScrollingListViewHolder(itemDummyListBinding: ItemDummyListBinding) :
    RecyclerView.ViewHolder(itemDummyListBinding.root)

class DummyScrollingCardViewHolder(itemDummyCardBinding: ItemDummyGridCardBinding) :
    RecyclerView.ViewHolder(itemDummyCardBinding.root)