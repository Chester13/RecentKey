package com.android.recentkey

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {}
    override fun onInterrupt() {}
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        performGlobalAction(GLOBAL_ACTION_RECENTS)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
    }
}