package com.santimattius.android.compose.talk.migration.started

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@InternalDeepLink("/migration_started")
class MigrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_migration_started)
    }
}