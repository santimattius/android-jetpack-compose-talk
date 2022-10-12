package com.santimattius.android.compose.talk.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.santimattius.android.compose.talk.BaltaIcon
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@ExperimentalFoundationApi
@InternalDeepLink("/layouts")
class LayoutsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                LazyColumn {
                    stickyHeader { Text(text = "Column") }
                    item { ColumnComponent() }
                    stickyHeader { Text(text = "Row") }
                    item { RowComponent() }
                    stickyHeader { Text(text = "Box") }
                    item { BoxComponent() }
                }
            }
        }
    }
}

@Composable
fun ColumnComponent() {
    Column {
        repeat(5) {
            BaltaIcon(contentDescription = "")
        }
    }
}

@Preview
@Composable
fun PreviewColumnComponent() {
    ComposeTalkContainer {
        ColumnComponent()
    }
}

@Composable
fun RowComponent() {
    Row {
        repeat(5) {
            BaltaIcon(contentDescription = "")
        }
    }
}

@Preview
@Composable
fun PreviewRowComponent() {
    ComposeTalkContainer {
        RowComponent()
    }
}

@Composable
fun BoxComponent() {
    Box {
        repeat(5) {
            BaltaIcon(contentDescription = "")
        }
    }
}

@Preview
@Composable
fun PreviewBoxComponent() {
    ComposeTalkContainer {
        BoxComponent()
    }
}
