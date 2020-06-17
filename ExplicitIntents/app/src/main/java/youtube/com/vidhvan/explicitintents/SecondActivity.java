package youtube.com.vidhvan.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.tv);
        // getIntent() method will catch the Intent that is responsible for
        // opening the current activity.
        Intent i = getIntent();
        String name = i.getStringExtra("KEY");

        textView.setText("Welcome, "+name);
    }
}