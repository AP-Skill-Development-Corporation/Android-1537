package youtube.com.vidhvan.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view)
    {
        /*1. You need not to create a NotificationChannel to all the devices that are below 8.0 (OREO)
            2. You Must Create a NotificationChannel for all the devices that are 8.0 and above*/
        /*Notification Manager is responsible to manage all the notifications from your app. Its a system Service*/

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        /*From here we are checking the current Android System Version
        and Deciding weather to create a notification channel or not*/
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            /*To Build the notification Channel*/
            NotificationChannel notificationChannel =
                    new NotificationChannel("FIRST_CHANNEL","AAD 1527 notifications",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableVibration(true);

            notificationChannel.enableLights(true);

            notificationChannel.setLockscreenVisibility(1);

            /*Creating the Notification Channel*/
            notificationManager.createNotificationChannel(notificationChannel);
        }

        /*Create a Notification*/
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"FIRST_CHANNEL");
        builder.setSmallIcon(R.drawable.home);
        builder.setContentTitle("Nothing can be compared to Home");
        builder.setContentText("This is the description part of the Notification");

        /*Set the Priority - For all the Devices that are below 8.0(Oreo - API LEVEL 26)*/
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        builder.setAutoCancel(true);

        /*Specify which action to be performed*/
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,23,intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        /*Adding the Action buttons*/
        builder.addAction(R.drawable.home,"Action-1",pi);
        builder.addAction(R.drawable.home,"Action-2",pi);

        /*BigPicture Style - to display the image when the notification is expanded*/
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.taj);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b));

        /*Issue the Notification Using the Notification Manager*/
        notificationManager.notify(232,builder.build());
    }
}