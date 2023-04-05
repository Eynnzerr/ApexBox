package com.eynnzerr.apexbox.ui

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import com.eynnzerr.apexbox.ui.theme.ApexBoxTheme
import com.tencent.mmkv.MMKV
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setImmerseStatusBar(window)
        MMKV.initialize(this)
        setContent {
            ApexBoxApp()
        }
    }

    private fun setImmerseStatusBar(window: Window) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, insets ->
            v.setPadding(0, 0, 0, 0)
            insets
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApexBoxApp()
}