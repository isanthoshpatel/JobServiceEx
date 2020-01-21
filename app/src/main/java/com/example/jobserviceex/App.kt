package com.example.jobserviceex

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var ch1 = NotificationChannel("ch1", "ch1", NotificationManager.IMPORTANCE_DEFAULT)
            var nm = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(ch1)

        }
    }
}