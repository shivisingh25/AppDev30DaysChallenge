package com.example.notifications

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {

     val CHANNEL_ID = "channelId"
     val CHANNEL_NAME = "channelName"
    val notificationId = 0

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        // Pending Intent
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0,intent,PendingIntent.FLAG_MUTABLE)


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("30 Days of App Dev Tutorial 27")
            .setContentText("Congratulations for showing up today")
            .setSmallIcon(R.drawable.baseline_insert_emoticon_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val btn = findViewById<Button>(R.id.button)

        val notificationManager = NotificationManagerCompat.from(this)

        btn.setOnClickListener {
            notificationManager.notify(notificationId,notification)
        }

    }

    private fun createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "This is my notification channel"
//                lightColor = Color.GREEN
//                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
             manager.createNotificationChannel(channel)
        }
    }
}

