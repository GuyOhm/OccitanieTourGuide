package com.example.android.occitanietourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // create a viewpager that will allow to display fragments and swipe beetween them
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // set the adapter onto the viewpager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
