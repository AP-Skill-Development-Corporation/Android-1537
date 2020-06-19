 package youtube.com.vidhvan.userinputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    private RadioGroup gender;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gender = findViewById(R.id.gender);
        
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                if(R.id.male == id){
                    Toast.makeText(MainActivity.this, "MALE IS SELECTED", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "FEMALE IS SELECTED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}