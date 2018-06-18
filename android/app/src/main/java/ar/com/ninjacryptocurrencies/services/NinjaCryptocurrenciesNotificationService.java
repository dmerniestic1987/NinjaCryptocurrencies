package ar.com.ninjacryptocurrencies.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import ar.com.ninjacryptocurrencies.R;
import ar.com.ninjacryptocurrencies.activity.AboutAppActivity;
import ar.com.ninjacryptocurrencies.activity.InfoDeveloperActivity;
import ar.com.ninjacryptocurrencies.activity.NinjaCryptocurrenciesActivity;

/**
 * Servicio encargado de escuchar las notificaciones
 */
public class NinjaCryptocurrenciesNotificationService extends FirebaseMessagingService {
    private static final String TAG = "NotificationService";
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    public NinjaCryptocurrenciesNotificationService() {
        super();
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String,String> data = remoteMessage.getData();
        String from = remoteMessage.getFrom();
        String messageId = remoteMessage.getMessageId();
        Log.i(TAG, "FROM: " + from + "MESSAGE ID: " +  messageId);


        if (remoteMessage.getNotification() != null) {
            String body = remoteMessage.getNotification().getBody();
            String title = remoteMessage.getNotification().getTitle();

            Intent intent = new Intent(this, NinjaCryptocurrenciesActivity.class);

            if (data != null && !data.isEmpty() && data.get("activity") != null){
                if ("ABOUT_APP".equals(data.get("activity").toUpperCase())){
                    intent =new Intent(this, AboutAppActivity.class);
                }
                else if ("INFO_DEVELOPER".equals(data.get("activity").toUpperCase())){
                    intent = new Intent(this, InfoDeveloperActivity.class);
                }
            }

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_ONE_SHOT);


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_1")
                    .setSmallIcon(R.mipmap.ic_stat_mood)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.ic_launcher))
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());

        }
    }


    @Override
    public void onSendError(String s, Exception e) {
        super.onSendError(s, e);
        if (user != null){
            Crashlytics.setUserEmail(user.getEmail());
            Crashlytics.setUserIdentifier(user.getUid());
        }
        Crashlytics.log(10, TAG, "Error al enviar el mensaje: " + e.getMessage());
        Crashlytics.logException(e);
    }
}
