package youtube.com.vidhvan.coronaupdates;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AlertDialog;

public class InternetConnectivity
{
    public static boolean isInternetAvailable(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activieNetwork = cm.getActiveNetworkInfo();

        return activieNetwork!=null && activieNetwork.isConnectedOrConnecting();
    }
}
