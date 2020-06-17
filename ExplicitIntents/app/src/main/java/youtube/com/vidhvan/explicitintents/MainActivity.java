package youtube.com.vidhvan.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.name);
    }

    /*The following method is created to launch the SecondActivity.java
    when the button is pressed*/
    public void gotoNext(View view)
    {
        //The Values that you read from EditText boxes will be in String Format initially,
        // If you want to read, another format value, then you need to convert it explicitly.
        String name = n.getText().toString();
        // Step 1 - Create an Object for Intent
        Intent i = new Intent(this,SecondActivity.class);
        // Since this an Explicit Intent, It has a specifit activity / Component to be opened.
        // That's why we have given source as this activity and destination as SecondActivity.
        i.putExtra("KEY",name);
        startActivity(i);
    }
}