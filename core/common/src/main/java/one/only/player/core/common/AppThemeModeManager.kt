package one.only.player.core.common

import android.app.UiModeManager
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate

enum class AppThemeMode {
    FOLLOW_SYSTEM,
    LIGHT,
    DARK,
}

object AppThemeModeManager {

    fun applyPlatformToCurrent(
        context: Context,
        mode: AppThemeMode,
    ) {
        applyPlatformNightMode(context = context, mode = mode)
    }

    fun applyToCurrent(
        context: Context,
        mode: AppThemeMode,
    ) {
        applyPlatformNightMode(context = context, mode = mode)
        applyCompatNightMode(mode = mode)
    }

    private fun applyCompatNightMode(mode: AppThemeMode) {
        val compatNightMode = mode.toCompatNightMode()
        if (AppCompatDelegate.getDefaultNightMode() == compatNightMode) return

        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppCompatDelegate.setDefaultNightMode(compatNightMode)
            return
        }
        Handler(Looper.getMainLooper()).post {
            AppCompatDelegate.setDefaultNightMode(compatNightMode)
        }
    }

    private fun applyPlatformNightMode(
        context: Context,
        mode: AppThemeMode,
    ) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) return

        val platformMode = when (mode) {
            AppThemeMode.FOLLOW_SYSTEM -> UiModeManager.MODE_NIGHT_AUTO
            AppThemeMode.LIGHT -> UiModeManager.MODE_NIGHT_NO
            AppThemeMode.DARK -> UiModeManager.MODE_NIGHT_YES
        }
        context.getSystemService(UiModeManager::class.java)?.setApplicationNightMode(platformMode)
    }

    private fun AppThemeMode.toCompatNightMode(): Int = when (this) {
        AppThemeMode.FOLLOW_SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        AppThemeMode.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
        AppThemeMode.DARK -> AppCompatDelegate.MODE_NIGHT_YES
    }
}
