package youtube.com.vidhvan.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText student_name, student_age;
    private TextView result;
    private StudentDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_age = findViewById(R.id.student_age);
        student_name = findViewById(R.id.student_name);
        result = findViewById(R.id.result);

        sdb = Room.databaseBuilder(this,StudentDatabase.class,"aad-1527")
                .allowMainThreadQueries()
                .build();

    }

    public void saveData(View view)
    {
        String n = student_name.getText().toString();
        int a = Integer.parseInt(student_age.getText().toString());
        StudentEntity studentEntity = new StudentEntity(n,a);
        sdb.studentDao().insert(studentEntity);
        student_name.setText("");
        student_age.setText("");
        student_name.clearFocus();
        student_age.clearFocus();
        retrieveData();
    }

    private void retrieveData()
    {
        List<StudentEntity> list = sdb.studentDao().getData();
        result.setText("");
        for(StudentEntity s : list){
            result.append(s.getId()+" "+s.getName()+" "+s.getAge()+"\n");
        }
    }
}