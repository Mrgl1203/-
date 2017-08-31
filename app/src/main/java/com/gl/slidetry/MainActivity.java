package com.gl.slidetry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.gl.slidetry.fragment.LeftFragment;
import com.gl.slidetry.fragment.MainFragment;
import com.gl.slidetry.fragment.RightFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Fragment mainFragment;
    Fragment leftFragment;
    Fragment rightFragment;
    Button leftbut;
    Button rightbut;
    Button gobut;

    int screenwidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenwidth = metrics.widthPixels;

        leftbut = (Button) findViewById(R.id.butleft);
        rightbut = (Button) findViewById(R.id.butright);
        gobut = (Button) findViewById(R.id.butgo);

        mainFragment = new MainFragment();
        leftFragment = new LeftFragment();
        rightFragment = new RightFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, mainFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.leftFrame, leftFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.rightFrame, rightFragment).commit();


        rightbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                drawerLayout.openDrawer(Gravity.END);
            }
        });

        leftbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        gobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SlideActivity.class));
            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                ViewGroup.LayoutParams layoutParams = drawerView.getLayoutParams();
                layoutParams.width=screenwidth;
                drawerView.setLayoutParams(layoutParams);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }
}
