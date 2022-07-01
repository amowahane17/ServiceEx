package com.example.serviceex;

import static com.example.serviceex.ChannelClass.ChannelId;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ServiceExample extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notiIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notiIntent,0);
        Notification notification = new NotificationCompat.Builder(this,ChannelId)
                .setContentTitle("My Notification")
                .setContentText("this is my Notification")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent).build();
         startForeground(1,notification);
         return  START_NOT_STICKY;
    }



}
