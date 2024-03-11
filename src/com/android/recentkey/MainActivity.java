package com.android.recentkey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAccessibility();

        startService(new Intent(MainActivity.this, myAccessibilityService.class));
        finish();
    }

    // To be able to perform recent app global action,
    // we need to enable AccessibilitySettings for RecentKey app.
    private void checkAccessibility() {
        if (!AccessibilityUtil.isAccessibilitySettingsOn(this)) {
            // To launch AccessibilitySettings UI
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        }
    }
}
