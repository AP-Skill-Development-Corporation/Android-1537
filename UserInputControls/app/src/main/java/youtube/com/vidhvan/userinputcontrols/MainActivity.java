 package youtube.com.vidhvan.userinputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

 public class MainActivity extends AppCompatActivity {

    private RadioGroup gender;
    private EditText name;
    private CheckBox english,telugu,hindi;
    private Switch avail;
    private Button submit;
    private TextView result;
    private Spinner spinner;

    private String person_name, person_gender, car_brand;
    private boolean availability = false;
    private int lang_known[];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllViews();

        lang_known = new int[3];

        // The following code is related to choosing gender with the help of RadioButtons
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                if(R.id.male == id){
                    person_gender = "Male";
                }else{
                    person_gender = "Female";
                }
            }
        });

        /*The following methods are For Checkboxes*/
        english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    lang_known[0] = 1;
                }else{
                    lang_known[0] = 0;
                }
            }
        });

        telugu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    lang_known[1] = 1;
                }else{
                    lang_known[1] = 0;
                }
            }
        });

        hindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    lang_known[2] = 1;
                }else{
                    lang_known[2] = 0;
                }
            }
        });

        avail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                availability = isChecked;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                car_brand = (String) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person_name = name.getText().toString();
                result.setText("Name: "+person_name+"\n");
                result.append("Gender: "+person_gender+"\n");
                result.append("Languages Known are: \n");
                if(lang_known[0] == 1)
                    result.append("English \n");
                if(lang_known[1] == 1)
                    result.append("Telugu\n");
                if(lang_known[2] == 1)
                    result.append("Hindi\n");
                result.append("Is Available ? "+availability+"\n");
                result.append("CAR BRAND "+car_brand);
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
         result = findViewById(R.id.result);
         spinner = findViewById(R.id.spinner);
     }
 }