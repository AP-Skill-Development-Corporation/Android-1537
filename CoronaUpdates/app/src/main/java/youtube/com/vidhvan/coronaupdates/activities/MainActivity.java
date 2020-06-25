package youtube.com.vidhvan.coronaupdates.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.internal.EverythingIsNonNull;
import youtube.com.vidhvan.coronaupdates.Covid19Service;
import youtube.com.vidhvan.coronaupdates.InternetConnectivity;
import youtube.com.vidhvan.coronaupdates.viewmodels.MainViewModel;
import youtube.com.vidhvan.coronaupdates.R;
import youtube.com.vidhvan.coronaupdates.adapters.CoronaAdapter;
import youtube.com.vidhvan.coronaupdates.models.CoronaModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView result;
    private ProgressBar progressBar;
    private TextView error_message;
    //global Variables
    private String slug;
    //ViewModel
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.i("MainActivity", "MainViewModel is initialized!");

        slug = getIntent().getStringExtra("SLUG");
        String country_n = getIntent().getStringExtra("COUNTRY");
        setTitle(country_n);
        result = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        error_message = findViewById(R.id.message);
        error_message.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        if(mainViewModel.coronalist.size() == 0){
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
            result.setAdapter(new CoronaAdapter(this,mainViewModel.coronalist));
        }

    }

    private void load_data_from_internet() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://api.covid19api.com")
                .build();

        Covid19Service service = retrofit.create(Covid19Service.class);
        Call<String> str = service.getDataOfIndia(slug);
        str.enqueue(new Callback<String>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.setVisibility(View.GONE);
                String data = response.body();
                try
                {
                    JSONArray array = new JSONArray(data);
                    for(int i = 0; i<array.length() ;i++){
                        JSONObject object = array.getJSONObject(i);
                        int confirmed_cases = object.getInt("Confirmed");
                        int active_cases = object.getInt("Active");
                        int deaths = object.getInt("Deaths");
                        String date = object.getString("Date");
                        CoronaModel coronaModel = new CoronaModel(date,confirmed_cases,active_cases,deaths);
                        mainViewModel.coronalist.add(coronaModel);
                    }
                    if(mainViewModel.coronalist.size() == 0){
                        error_message.setVisibility(View.VISIBLE);
                    }
                    else{
                        result.setAdapter(new CoronaAdapter(MainActivity.this,mainViewModel.coronalist));
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.i("MAIN", "onFailure: "+t.getMessage());
            }
        });
    }
}