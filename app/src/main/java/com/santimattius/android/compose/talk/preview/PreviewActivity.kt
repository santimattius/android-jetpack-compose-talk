package com.santimattius.android.compose.talk.preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@InternalDeepLink("/preview")
class ExamplePreviewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                MessageCard("Android")
            }
        }
    }
}

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name !")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMessageCard() {
    ComposeTalkContainer {
        MessageCard("Android")
    }
}