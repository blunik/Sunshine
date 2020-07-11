package com.example.android.sunshine.sync;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class SunshineSyncIntentService extends IntentService {
    public SunshineSyncIntentService(){
        super("SunshineSyncIntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SunshineSyncTask.syncWeather(this);
    }
}
