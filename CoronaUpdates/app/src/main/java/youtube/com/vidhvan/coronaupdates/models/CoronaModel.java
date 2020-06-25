package youtube.com.vidhvan.coronaupdates.models;

public class CoronaModel
{
    String date;
    int total_cases;
    int active_cases;
    int deaths;

    public CoronaModel(String date, int total_cases, int active_cases, int deaths) {
        this.date = date;
        this.total_cases = total_cases;
        this.active_cases = active_cases;
        this.deaths = deaths;
    }

    public String getDate() {
        return date;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public int getActive_cases() {
        return active_cases;
    }

    public int getDeaths() {
        return deaths;
    }
}
