package youtube.com.vidhvan.coronaupdates.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import youtube.com.vidhvan.coronaupdates.models.CoronaModel;

public class MainViewModel extends ViewModel
{
    public List<CoronaModel> coronalist;
    // It's the Beginning
    public MainViewModel()
    {
        coronalist = new ArrayList<>();
        Log.i("MainViewModel", "A New ViewModel is Created!");
    }

    // It's the Conclusion
    @Override
    protected void onCleared()
    {
        super.onCleared();
        Log.i("MainViewModel", "The ViewModel is Destroyed!");
    }
}
