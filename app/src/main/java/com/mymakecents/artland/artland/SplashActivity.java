package com.mymakecents.artland.artland;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {
    //Wasted 1 Hour for this crap!!!!!!
//    @Override
//    public void onCreate(Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        // Start home activity
//        startActivity(new Intent(this, CameraActivity.class));
//        Toast.makeText(this, "Closing...", Toast.LENGTH_LONG).show();
//        // close splash activity
//        SplashActivity.this.finish();
//
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, DashboardActivity.class));

        // close splash activity
        SplashActivity.this.finish();
    }
}
