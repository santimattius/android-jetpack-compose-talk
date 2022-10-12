package com.santimattius.android.compose.talk.shared.deeplink

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler

@DeepLinkHandler(AppModule::class)
class DeepLinkActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate =
            DeepLinkDelegate(AppModuleRegistry())
        deepLinkDelegate.dispatchFrom(this)
        finish()
    }
}