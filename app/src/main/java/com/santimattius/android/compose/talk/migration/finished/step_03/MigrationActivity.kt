package com.santimattius.android.compose.talk.migration.finished.step_03

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@InternalDeepLink("/migration_final_step")
class MigrationActivity : AppCompatActivity() {

    private val items = PlaceholderContent.ITEMS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                Scaffold(
                    topBar = { TopAppBar(title = { Text(text = "Migration final step") }) }
                ) { padding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)) {
                        val context = LocalContext.current
                        ListOfContent(items = items) {
                            Toast.makeText(context, it.content, Toast.LENGTH_SHORT).show()
                        }
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