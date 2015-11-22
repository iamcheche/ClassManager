package com.capstone.jhea.classmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setLogo();
        runNextActivity();
    }

    private void setLogo(){
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int width = display.widthPixels;// (int) (display.widthPixels - (display.widthPixels * 0.1));
        int height = display.heightPixels;//(int) (width + (width * 0.2));

        LinearLayout li = (LinearLayout) findViewById(R.id.splash_id_layout);
        LayoutParams lp = new LayoutParams(width, height);
        ImageView logo = new ImageView(this);
        logo.setImageResource(R.drawable.logo);
        li.addView(logo, lp);
    }

    private void runNextActivity(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
