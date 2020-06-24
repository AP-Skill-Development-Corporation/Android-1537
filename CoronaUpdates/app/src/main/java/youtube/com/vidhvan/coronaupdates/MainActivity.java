package youtube.com.vidhvan.coronaupdates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView result;
    private ProgressBar progressBar;
    private List<CoronaModel> coronalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        coronalist = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://api.covid19api.com")
                .build();

        Covid19Service service = retrofit.create(Covid19Service.class);
        Call<String> str = service.getDataOfIndia();
        str.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.setVisibility(View.GONE);
                String data = response.body();
                try
                {
                    JSONArray array = new JSONArray(data);
                    for(int i = array.length()-1; i>=0 ;i--){
                        JSONObject object = array.getJSONObject(i);
                        int confirmed_cases = object.getInt("Confirmed");
                        int active_cases = object.getInt("Active");
                        int deaths = object.getInt("Deaths");
                        String date = object.getString("Date");
                        CoronaModel coronaModel = new CoronaModel(date,confirmed_cases,active_cases,deaths);
                        coronalist.add(coronaModel);
                    }

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.i("MAIN", "onFailure: "+t.getMessage());
            }
        });
    }
}