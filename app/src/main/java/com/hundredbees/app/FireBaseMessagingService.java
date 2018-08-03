package com.hundredbees.app;

import android.app.PendingIntent;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;
import java.util.List;

public class FireBaseMessagingService extends FirebaseMessagingService {

        @Override
        public void onMessageReceived(RemoteMessage message) {
            sendMyNotification(message.getNotification().getBody(),message.getNotification().getTitle());
        }


        private void sendMyNotification(String message, String title) {

            //On click of notification it redirect to this Activity
            Intent intent = new Intent(this, NotificationActivity.class);
//            ArrayList<String> notificationList = new ArrayList<String>();
//            notificationList.add(message);
//            notificationList.add(title);
            intent.putExtra("title",title);
            intent.putExtra("message",message);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(false)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0, notificationBuilder.build());
        }
    }