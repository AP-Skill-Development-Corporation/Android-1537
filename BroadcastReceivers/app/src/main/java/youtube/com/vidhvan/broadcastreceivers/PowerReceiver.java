package youtube.com.vidhvan.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.widget.ImageView;

public class PowerReceiver extends BroadcastReceiver {

    private ImageView imageView;

    public PowerReceiver(ImageView imageView)
    {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
            imageView.setImageResource(R.drawable.power_connected);
        }else{
            imageView.setImageResource(R.drawable.power_disconnected);
        }
    }
}
