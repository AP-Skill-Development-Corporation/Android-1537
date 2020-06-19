 package youtube.com.vidhvan.userinputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    private RadioGroup gender;
    private EditText name;
    private CheckBox english,telugu,hindi;
    private Switch avail;
    private Button submit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllViews();

        // The following code is related to choosing gender with the help of RadioButtons
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

        /*The following methods are For Checkboxes*/
        english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "USER SELECTED ENGLISH", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "USER DESELECTED ENGLISH", Toast.LENGTH_SHORT).show();
                }
            }
        });

        telugu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "USER SELECTED TELUGU", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "USER DESELECTED TELUGU", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "USER SELECTED HINDI", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "USER DESELECTED HINDI", Toast.LENGTH_SHORT).show();
                }
            }
        });

        avail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "The user selected yes", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "The user selected no", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

     private void initializeAllViews() {
         // Connecting the Objects with the views on the activity_main.xml
         gender = findViewById(R.id.gender);
         name = findViewById(R.id.name);
         english = findViewById(R.id.english);
         telugu = findViewById(R.id.telugu);
         hindi = findViewById(R.id.hindi);
         avail = findViewById(R.id.avail);
         submit = findViewById(R.id.submit);
     }
 }