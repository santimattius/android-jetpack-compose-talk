package com.santimattius.android.compose.talk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private val features = FeaturesRepository.all

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                MainScreen(features = features)
            }
        }
    }

}

@ExperimentalMaterialApi
@Composable
fun MainScreen(features: List<Feature>) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {

            val handler = LocalUriHandler.current

            LazyColumn {
                items(features, key = { it.id }) { item ->
                    ListItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_avo),
                                contentDescription = item.title,
                                modifier = Modifier.size(32.dp)
                            )
                        },
                        text = { Text(text = item.title) },
                        secondaryText = { Text(text = item.description) },
                        modifier = Modifier.clickable {
                            handler.openUri(item.deepLink)
                        })
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ComposeTalkContainer {
        MainScreen(features = FeaturesRepository.all)
    }
}
