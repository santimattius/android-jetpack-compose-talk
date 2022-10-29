package com.santimattius.android.compose.talk.migration.finished.step_02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent
import com.santimattius.android.compose.talk.shared.ComposeTalkContainer
import com.santimattius.android.compose.talk.shared.deeplink.InternalDeepLink

@InternalDeepLink("/migration_second_step")
class MigrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_migration_second_step)
    }
}