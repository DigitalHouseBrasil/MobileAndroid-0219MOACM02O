package br.com.digitalhouse.gamesapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class GamesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
