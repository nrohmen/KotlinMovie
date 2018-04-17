package com.nrohmen.kotlinmovie.util

import android.content.Context
import android.content.SharedPreferences
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.graphics.drawable.DrawableCompat

object Utils {

    private const val PREFERENCES_FILE = "settings"

    fun readSharedSetting(ctx: Context, settingName: String, defaultValue: String): String? {
        val sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        return sharedPref.getString(settingName, defaultValue)
    }

    fun saveSharedSetting(ctx: Context, settingName: String, settingValue: String) {
        val sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(settingName, settingValue)
        editor.apply()
    }

}
