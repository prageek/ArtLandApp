package com.mymakecents.artland.artland;

import android.app.Application;
import android.content.Context;

/**
 * Created by prageeth on 10/21/17.
 */

public class App extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
    }

    public static Context getContext() {
        return applicationContext;
    }
}
