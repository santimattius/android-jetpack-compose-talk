package com.santimattius.android.compose.talk.migration

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.android.compose.talk.databinding.FragmentItemBinding
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 *
 */
class ItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val onClick: (PlaceholderItem) -> Unit,
) : RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item, onClick)

    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val contentView: TextView = binding.content


        fun bind(item: PlaceholderItem, onClick: (PlaceholderItem) -> Unit) {
            contentView.text = item.content
            itemView.setOnClickListener {
                onClick(item)
            }

        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val fragmentItemBinding = FragmentItemBinding.inflate(layoutInflater,
                    parent,
                    false)
                return ViewHolder(fragmentItemBinding)
            }
        }
    }
}