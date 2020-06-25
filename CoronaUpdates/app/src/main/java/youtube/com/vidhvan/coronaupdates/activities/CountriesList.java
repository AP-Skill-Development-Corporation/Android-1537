package youtube.com.vidhvan.coronaupdates.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import youtube.com.vidhvan.coronaupdates.Covid19Service;
import youtube.com.vidhvan.coronaupdates.R;
import youtube.com.vidhvan.coronaupdates.adapters.CountriesAdapter;
import youtube.com.vidhvan.coronaupdates.models.CountriesModel;

public class CountriesList extends AppCompatActivity {

    private RecyclerView countries_list;
    private ProgressBar progressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_list);

        setTitle("Countries");
        countries_list = findViewById(R.id.countries_list);
        progressBar = findViewById(R.id.progress);
        
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://api.covid19api.com")
                .build();
        
        Covid19Service covid19Service = retrofit.create(Covid19Service.class);
        Call<String> data = covid19Service.getCountries();
        data.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String d = response.body();
                progressBar.setVisibility(View.GONE);
                List<CountriesModel> list = new ArrayList<>();
                try {
                    JSONArray array = new JSONArray(d);
                    for(int i=0; i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);
                        String c = object.getString("Country");
                        String s = object.getString("Slug");
                        CountriesModel countriesModel = new CountriesModel(c,s);
                        list.add(countriesModel);
                    }
                   CountriesAdapter countriesAdapter = new CountriesAdapter(CountriesList.this,list);
                    countries_list.setAdapter(countriesAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}