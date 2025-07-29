package org.torproject.android.service.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.torproject.android.service.OrbotService
import org.torproject.android.service.util.Prefs

class PowerConnectionReceiver(private val mService: OrbotService) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Prefs.limitSnowflakeProxyingCharging()) {
            if (intent.action == Intent.ACTION_POWER_CONNECTED) {
                mService.setHasPower(true)
            } else if (intent.action == Intent.ACTION_POWER_DISCONNECTED) {
                mService.setHasPower(false)
            }
        }
    }
}