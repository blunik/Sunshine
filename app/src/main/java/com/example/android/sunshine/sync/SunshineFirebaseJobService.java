package com.example.android.sunshine.sync;

import android.content.Context;
import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class SunshineFirebaseJobService extends JobService {

    private AsyncTask<Void, Void, Void> mFetchWeatherTask;
    @Override
    public boolean onStartJob(final JobParameters job) {
       mFetchWeatherTask = new AsyncTask<Void, Void, Void>() {
           @Override
           protected Void doInBackground(Void... voids) {
               Context context = getApplicationContext();
               SunshineSyncTask.syncWeather(context);
               return null;
           }

           @Override
           protected void onPostExecute(Void aVoid) {
               jobFinished(job, false);
           }
       };
       mFetchWeatherTask.execute();
       return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
      if (mFetchWeatherTask != null){
          mFetchWeatherTask.cancel(true);
      }
      return true;
    }
}
