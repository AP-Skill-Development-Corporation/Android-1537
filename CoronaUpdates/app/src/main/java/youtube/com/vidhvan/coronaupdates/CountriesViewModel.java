package youtube.com.vidhvan.coronaupdates;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import youtube.com.vidhvan.coronaupdates.models.CountriesModel;

public class CountriesViewModel extends ViewModel
{

    public List<CountriesModel> lists;

    public CountriesViewModel() {
        lists = new ArrayList<>();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
