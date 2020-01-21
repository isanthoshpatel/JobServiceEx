package com.example.jobserviceex

import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.NotificationCompat

class JobServiceChild : JobService(){
    var b:Boolean = false
    override fun onStartJob(params: JobParameters?): Boolean {

        Thread(object:Runnable {
            override fun run() {
                for(i in 0..10) {

                    var n = NotificationCompat.Builder(this@JobServiceChild, "ch1")
                        .setContentTitle("task $i")
                        .setContentText("running...$i")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(
                            PendingIntent.getActivity(
                                this@JobServiceChild,
                                0,
                                Intent(this@JobServiceChild, MainActivity::class.java),
                                0
                            )
                        )
                        .build()
                    if (b) return
                    startForeground(1,n)
                    SystemClock.sleep(5000)
                }
                jobFinished(params,true)


            }
        }).start()

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {


        b = true
        return true
    }
}