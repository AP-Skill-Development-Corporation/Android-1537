package youtube.com.vidhvan.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int version_images[];
    private String version_names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        // the following method will set up the data
        setUpData();


        recyclerView.setAdapter(new RecyclerAdapter(this,version_images,version_names));
    }

    private void setUpData()
    {
        version_images = new int[]{R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,
        R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,
        R.drawable.honeycomb,R.drawable.icecreamsandwich,R.drawable.jellybean,
        R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,
        R.drawable.oreo,R.drawable.pie,R.drawable.q,R.drawable.r};

        version_names = new String[]{"Alpha","Beta","Cupcake","Donut","Eclair","Froyo",
        "Gingerbread","Honeycomb","Icecream sandwich","JellyBean","Kitkat","Lollipop",
        "Marshmallow","Nougat","Oreo","Pie","Q","R"};

        if(version_names.length == version_images.length){
            Toast.makeText(this, "DATA IS VALID", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "DATA IS NOT VALID", Toast.LENGTH_SHORT).show();
        }
    }
}