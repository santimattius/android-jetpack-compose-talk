package com.santimattius.android.compose.talk

import java.util.*

object FeaturesRepository {

    val all: List<Feature> = mutableListOf(
        Feature(
            title = "Imperative UI",
            description = "using imperative programming",
            deepLink = "talk://imperative",
        ),
        Feature(
            title = "Declarative UI",
            description = "using declarative programming",
            deepLink = "talk://declarative",
        ),
        Feature(
            title = "Compose State Management",
            description = "using state in compose",
            deepLink = "talk://state",
        ),
        Feature(
            title = "Migration to Compose",
            description = "migrate from AndroidView to JetpackCompose",
            deepLink = "talk://migration",
        ),
        Feature(
            title = "Animations",
            description = "using animations in compose",
            deepLink = "talk://animations",
        ),
    )

}


data class Feature(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val deepLink: String,
)