package com.santimattius.android.compose.talk.shared.deeplink

import com.airbnb.deeplinkdispatch.DeepLinkSpec

internal const val BASE_DEEP_LINK = "app://talk"

@DeepLinkSpec(prefix = [BASE_DEEP_LINK])
@Retention(AnnotationRetention.RUNTIME)
annotation class InternalDeepLink(vararg val value: String)