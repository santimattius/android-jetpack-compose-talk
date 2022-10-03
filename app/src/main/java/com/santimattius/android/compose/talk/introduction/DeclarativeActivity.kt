package com.santimattius.android.compose.talk.introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer

class DeclarativeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                DeclarativeContent()
            }
        }
    }
}

@Composable
private fun DeclarativeContent() {
    var counter by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)) {

        Text(
            text = "$counter",
            style = MaterialTheme.typography.h1
        )

        Button(
            onClick = {
                counter += 1
            },
            content = {
                Text(text = stringResource(id = R.string.text_button))
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTalkContainer {
        DeclarativeContent()
    }
}