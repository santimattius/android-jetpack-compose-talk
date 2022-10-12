package com.santimattius.android.compose.talk.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@JvmInline
value class LottieAnimationIterations(val iterations: Int)

val LocalLottieAnimationIterations =
    compositionLocalOf { LottieAnimationIterations(LottieConstants.IterateForever) }

@InternalDeepLink("/animations")
class AnimationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTalkContainer {
                Scaffold(
                    topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.title_activity_animations)) }) }
                ) { padding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                    ) {
                        CompositionLocalProvider(LocalLottieAnimationIterations provides LottieAnimationIterations(
                            100)) {
                            Loader()
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(composition,
        iterations = LocalLottieAnimationIterations.current.iterations)
    LottieAnimation(
        composition = composition,
        progress = { progress }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeTalkContainer {
        Loader()
    }
}