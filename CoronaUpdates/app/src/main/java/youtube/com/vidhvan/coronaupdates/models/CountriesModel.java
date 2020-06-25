package youtube.com.vidhvan.coronaupdates.models;

public class CountriesModel
{
    String country_name;
    String slug;

    public CountriesModel(String country_name, String slug) {
        this.country_name = country_name;
        this.slug = slug;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getSlug() {
        return slug;
    }
}
