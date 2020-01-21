package com.example.jobserviceex

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.KeyEventDispatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt1.setOnClickListener {

            var jobinfo = JobInfo.Builder(1, ComponentName(this,JobServiceChild::class.java))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build()
            var jobSchedular  = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            jobSchedular.schedule(jobinfo)
        }
        bt2.setOnClickListener {
           var jobSchedular = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            jobSchedular.cancel(1)
        }
    }
}
