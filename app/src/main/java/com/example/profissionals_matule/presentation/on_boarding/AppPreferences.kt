package com.example.profissionals_matule.presentation.on_boarding

import android.content.Context

class AppPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    var isOnboardingShown: Boolean
        get() = sharedPreferences.getBoolean("is_onboarding_shown", false)
        set(value) = sharedPreferences.edit().putBoolean("is_onboarding_shown", value).apply()
    var isUserLogin: Boolean
        get() = sharedPreferences.getBoolean("user_logged_in", false)
        set(value) = sharedPreferences.edit().putBoolean("user_logged_in", value).apply()
}