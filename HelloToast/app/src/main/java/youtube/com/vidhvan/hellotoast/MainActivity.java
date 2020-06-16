package youtube.com.vidhvan.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCount = findViewById(R.id.count_tv);
    }

    // The following method will be invoked when the toast button is clicked
    public void showToast(View view)
    {
        Toast.makeText(this, "APSSDC & SVEC", Toast.LENGTH_SHORT).show();
    }

    /* This method will be called
    * when the count button on the activity_main.xml
    * is clicked*/
    public void showCount(View view)
    {
        count++;
        mCount.setText(String.valueOf(count));
    }
}