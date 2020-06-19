package youtube.com.vidhvan.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Main", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main", "onResume");
    }

    // Now Your App is said to be in running state


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main", "onDestroy");
    }

    // the activity is killed.


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Main", "onRestart");
    }
}