package com.wendy.notificationapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var sec = editText.text.toString().toInt()
            var i = Intent(applicationContext, MyBroadcastReceiver::class.java)
            var pi = PendingIntent.getBroadcast(applicationContext,  111,i,0)
            var am : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (1000*sec),pi)
            Toast.makeText(applicationContext,"Alarm is set for $sec Seconds", Toast.LENGTH_LONG).show()

        }
    }
}