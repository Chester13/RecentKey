package com.android.recentkey

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException

/**
 * Created by wangxiandeng on 2016/11/25.
 */
object AccessibilityUtil {
    fun doBack(service: AccessibilityService) {
        service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }

    fun doPullDown(service: AccessibilityService) {
        service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
    }

    fun doPullUp(service: AccessibilityService) {
        service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }

    fun doLeftOrRight(service: AccessibilityService) {
        service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS)
    }

    fun isAccessibilitySettingsOn(context: Context): Boolean {
        var accessibilityEnabled = 0
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                context.contentResolver,
                Settings.Secure.ACCESSIBILITY_ENABLED
            )
        } catch (e: SettingNotFoundException) {
            e.printStackTrace()
        }
        if (accessibilityEnabled == 1) {
            val services = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
            if (services != null) {
                return services.lowercase().contains(context.packageName.lowercase())
            }
        }
        return false
    }
}