package com.santimattius.android.compose.talk.migration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@InternalDeepLink("/migration")
class MigrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_migration)
    }
}