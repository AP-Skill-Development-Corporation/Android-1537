package youtube.com.vidhvan.coronaupdates.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import youtube.com.vidhvan.coronaupdates.InternetConnectivity;
import youtube.com.vidhvan.coronaupdates.viewmodels.CountriesViewModel;
import youtube.com.vidhvan.coronaupdates.Covid19Service;
import youtube.com.vidhvan.coronaupdates.R;
import youtube.com.vidhvan.coronaupdates.adapters.CountriesAdapter;
import youtube.com.vidhvan.coronaupdates.models.CountriesModel;

public class CountriesList extends AppCompatActivity {

    private RecyclerView countries_list;
    private ProgressBar progressBar;
    private CountriesViewModel countriesViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_list);
        setTitle("Countries");
        countriesViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        countries_list = findViewById(R.id.countries_list);
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);

        if(countriesViewModel.lists.size() == 0){
            if(!InternetConnectivity.isInternetAvailable(this)){

                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.internet)
                        .setTitle("Sorry! You are not connected To Internet!")
                        .setMessage("Try Connecting back to internet and Retry to load our Data!\nClick Cancel to close the app\nClick Ok to Retry!")
                        .setPositiveButton("OK",null)
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();

            }else{
                load_data_from_internet();
            }
        }
        else
        {
            countries_list.setAdapter(new CountriesAdapter(this,countriesViewModel.lists));
        }

    }

    private void load_data_from_internet() {
        progressBar.setVisibility(View.VISIBLE);
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
                try {
                    JSONArray array = new JSONArray(d);
                    for(int i=0; i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);
                        String c = object.getString("Country");
                        String s = object.getString("Slug");
                        CountriesModel countriesModel = new CountriesModel(c,s);
                        countriesViewModel.lists.add(countriesModel);
                    }
                    CountriesAdapter countriesAdapter = new CountriesAdapter(CountriesList.this,countriesViewModel.lists);
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