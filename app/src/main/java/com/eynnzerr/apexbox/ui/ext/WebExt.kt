package com.eynnzerr.apexbox.ui.ext

import android.content.Context
import android.content.Intent
import android.net.Uri

fun startBrowser(url: String, context: Context) {
    val uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}