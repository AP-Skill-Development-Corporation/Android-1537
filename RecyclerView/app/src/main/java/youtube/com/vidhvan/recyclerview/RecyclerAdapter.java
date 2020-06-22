package youtube.com.vidhvan.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>
{

    Context context;
    int images[];
    String names[];

    public RecyclerAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    /*The following method will be used to inflate(Attach) the layout to each and every entry in the
        recyclerview*/
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new RecyclerViewHolder(v);
    }

    /*The following method will be used to populate data on the right views in one row of the
        recyclerview*/
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.version_name.setText(names[position]);
        holder.version_image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
