package youtube.com.vidhvan.tabsfornavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        /*Return fragments based on the position of your current screen*/
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new FirstFragment();
                case 1: return new SecondFragment();
                case 2: return new ThirdFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "RED";
                case 1: return "BLUE";
                case 2: return "GREEN";
            }
            return super.getPageTitle(position);
        }
    }
}