package youtube.com.vidhvan.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // We will inflate (attach) an options menu from the following method.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    // We will define the actions for option menu item selection.

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.first:
                Toast.makeText(this, "First Option is Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(this, "Second Option is Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                showAlert();
                break;
            case R.id.fourth:
                Toast.makeText(this, "Fourth Option is Selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    // In this method we are going to write code to display the alert dialog.
    private void showAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cup);
        builder.setTitle("Third Option is for Coffee!");
        builder.setMessage("Would you like to have a cup of coffee ? ");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Come Let's Have it.", Toast.LENGTH_SHORT).show();
                /*dialog.dismiss();*/
            }
        });
        builder.show();
    }
}