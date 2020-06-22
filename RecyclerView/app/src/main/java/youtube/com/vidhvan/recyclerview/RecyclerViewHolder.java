package youtube.com.vidhvan.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    public TextView version_name;
    public ImageView version_image;

    public RecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
        version_image = itemView.findViewById(R.id.version_image);
        version_name = itemView.findViewById(R.id.version_name);
    }
}
