package com.santimattius.android.compose.talk.migration.finished.step_01

import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent.PlaceholderItem
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer

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

    override fun onViewRecycled(holder: ViewHolder) {
        holder.composeView.disposeComposition()
    }

    class ViewHolder(val composeView: ComposeView) : RecyclerView.ViewHolder(composeView) {

        init {
            composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        }

        fun bind(item: PlaceholderItem, onClick: (PlaceholderItem) -> Unit) {
            composeView.setContent {
                ComposeTalkContainer {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onClick(item)
                            }
                            .padding(16.dp)
                    ) {
                        Text(text = item.content)
                    }
                }
            }

        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(ComposeView(parent.context))
            }
        }
    }
}