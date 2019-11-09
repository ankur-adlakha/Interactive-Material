package com.bluexpresso.materialplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluexpresso.materialplayground.databinding.ItemMaterialComponentBinding

class MaterialComponentsAdapter :
    RecyclerView.Adapter<MaterialComponentsAdapter.MaterialComponentsViewHolder>() {
    private val materialComponents: Array<MaterialComponents> = MaterialComponents.values()
    lateinit var onItemClick: (String) -> Unit
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MaterialComponentsViewHolder {
        return MaterialComponentsViewHolder(
            ItemMaterialComponentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = materialComponents.size

    override fun onBindViewHolder(holder: MaterialComponentsViewHolder, position: Int) {
        holder.bind()
    }

    fun setOnItemClickListener(onItemClick: (String) -> Unit) {
        this.onItemClick = onItemClick
    }

    inner class MaterialComponentsViewHolder(private val itemMaterialComponentBinding: ItemMaterialComponentBinding) :
        RecyclerView.ViewHolder(itemMaterialComponentBinding.root) {
        fun bind() {
            itemMaterialComponentBinding.materialComponentTitle.text =
                materialComponents[adapterPosition].title
            itemMaterialComponentBinding.materialComponentTitle.setOnClickListener {
                onItemClick(materialComponents[adapterPosition].title)
            }
        }
    }

}
