package youtube.com.vidhvan.coronaupdates;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Covid19Service
{
    @GET("/total/dayone/country/{country}")
    Call<String> getDataOfIndia(@Path("country") String country);

    @GET("/countries")
    Call<String> getCountries();
}

