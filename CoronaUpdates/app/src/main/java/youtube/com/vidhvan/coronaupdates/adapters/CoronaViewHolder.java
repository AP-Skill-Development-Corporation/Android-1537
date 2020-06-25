package youtube.com.vidhvan.coronaupdates.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import youtube.com.vidhvan.coronaupdates.R;

public class CoronaViewHolder extends RecyclerView.ViewHolder
{
    TextView date, total_cases, active_cases, deaths;

    public CoronaViewHolder(@NonNull View itemView) {
        super(itemView);

        date = itemView.findViewById(R.id.dates);
        total_cases = itemView.findViewById(R.id.total_cases);
        active_cases = itemView.findViewById(R.id.active_cases);
        deaths = itemView.findViewById(R.id.total_deaths);
    }
}
