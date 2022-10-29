package com.santimattius.android.compose.talk

import com.santimattius.android.compose.talk.shared.deeplink.BASE_DEEP_LINK
import java.util.*

object FeaturesRepository {

    val all: List<Feature> = mutableListOf(
        Feature(
            title = "Imperative UI",
            description = "using imperative programming",
            tag = "imperative",
        ),
        Feature(
            title = "Declarative UI",
            description = "using declarative programming",
            tag = "declarative",
        ),
        Feature(
            title = "Compose State Management",
            description = "using state in compose",
            tag = "state",
        ),
        Feature(
            title = "Migration to Compose",
            description = "migrate from AndroidView to JetpackCompose",
            tag = "migration_started",
        ),
        Feature(
            title = "Step 01 - Migration to Compose",
            description = "Migrate recyclerview items",
            tag = "migration_first_step",
        ),
        Feature(
            title = "Step 02 - Migration to Compose",
            description = "Migrate fragment",
            tag = "migration_second_step",
        ),
        Feature(
            title = "Step 03 - Migration to Compose",
            description = "Migrate all activity components",
            tag = "migration_final_step",
        ),
        Feature(
            title = "Animations",
            description = "using animations in compose",
            tag = "animations",
        ),
        Feature(
            title = "Previews",
            description = "using compose preview tool",
            tag = "preview",
        ),
        Feature(
            title = "Layouts",
            description = "using layouts in compose",
            tag = "layouts",
        ),
    )

}


data class Feature(
    val title: String,
    val description: String,
    val tag: String,
) {
    val id: String = UUID.randomUUID().toString()

    val deepLink: String
        get() = "$BASE_DEEP_LINK/$tag"
}