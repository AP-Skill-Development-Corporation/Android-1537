package youtube.com.vidhvan.coronaupdates;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Service
{
    @GET("/total/dayone/country/india")
    Call<String> getDataOfIndia();
}

