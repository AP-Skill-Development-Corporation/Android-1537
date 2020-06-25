package youtube.com.vidhvan.coronaupdates.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import youtube.com.vidhvan.coronaupdates.models.CountriesModel;
import youtube.com.vidhvan.coronaupdates.activities.MainActivity;
import youtube.com.vidhvan.coronaupdates.R;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>
{
    Context context;
    List<CountriesModel> list;

    public CountriesAdapter(Context context, List<CountriesModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design_for_countries,parent,false);
        return new CountriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.country_name.setText(list.get(position).getCountry_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CountriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView country_name;

        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);

            country_name = itemView.findViewById(R.id.country_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String slug = list.get(position).getSlug();
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("SLUG",slug);
            intent.putExtra("COUNTRY",list.get(position).getCountry_name());
            context.startActivity(intent);
        }
    }
}
