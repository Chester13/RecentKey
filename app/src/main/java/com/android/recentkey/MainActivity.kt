package com.android.recentkey

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkAccessibility()
        startService(Intent(this@MainActivity, MyAccessibilityService::class.java))
        finish()
    }

    // To be able to perform recent app global action,
    // we need to enable AccessibilitySettings for RecentKey app.
    private fun checkAccessibility() {
        if (!AccessibilityUtil.isAccessibilitySettingsOn(this)) {
            // To launch AccessibilitySettings UI
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
    }
}