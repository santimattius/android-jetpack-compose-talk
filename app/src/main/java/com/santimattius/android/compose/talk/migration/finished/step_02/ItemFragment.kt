package com.santimattius.android.compose.talk.migration.finished.step_02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val items = PlaceholderContent.ITEMS
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeTalkContainer {
                    val context = LocalContext.current
                    ListOfContent(items = items) {
                        Toast.makeText(context, it.content, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

@Composable
private fun ListOfContent(
    items: List<PlaceholderContent.PlaceholderItem>,
    onItemClick: (PlaceholderContent.PlaceholderItem) -> Unit,
) {
    LazyColumn {
        items(items, key = { it.id }) { item ->
            ContentItem(item = item, onClick = onItemClick)
        }
    }
}

@Composable
private fun ContentItem(
    modifier: Modifier = Modifier,
    item: PlaceholderContent.PlaceholderItem,
    onClick: (PlaceholderContent.PlaceholderItem) -> Unit,
) {
    ComposeTalkContainer {
        Column(
            modifier = modifier
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