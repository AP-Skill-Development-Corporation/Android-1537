package youtube.com.vidhvan.coronaupdates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaViewHolder>
{

    Context context;
    List<CoronaModel> coronaModels;

    public CoronaAdapter(Context context, List<CoronaModel> coronaModels)
    {
        this.context = context;
        this.coronaModels = coronaModels;
    }

    @NonNull
    @Override
    public CoronaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new CoronaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaViewHolder holder, int position) {

        holder.date.setText(coronaModels.get(position).date);
        holder.total_cases.setText("Total :"+String.valueOf(coronaModels.get(position).getTotal_cases()));
        holder.active_cases.setText("Active :"+String.valueOf(coronaModels.get(position).getActive_cases()));
        holder.deaths.setText("Deaths :"+String.valueOf(coronaModels.get(position).getDeaths()));

    }

    @Override
    public int getItemCount() {
        return coronaModels.size();
    }
}

