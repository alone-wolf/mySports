package com.wh.mysports;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SportRepository {
    private LiveData<List<Sport>> allSportsLive;
    private SportDao sportDao;

    SportRepository(Context context) {
        SportDatabase sportDatabase = SportDatabase.getDatabase(context.getApplicationContext());
        sportDao = sportDatabase.getSportDao();
        allSportsLive = sportDao.getAllSportsLive();
    }

    void insertSports(Sport... sports) {
        new InsertAsyncTask(sportDao).execute(sports);
    }

    void updateSports(Sport... sports){
        new UpdateAsyncTask(sportDao).execute(sports);
    }

    void deleteSports(Sport... sports){
        new DeleteAsyncTask(sportDao).execute(sports);
    }

    void setAllSportsLive(){
        new DeleteAllAsyncTask(sportDao).execute();
    }

    LiveData<List<Sport>> getAllSportsLive() {
        return allSportsLive;
    }

    static class InsertAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao sportDao;

        InsertAsyncTask(SportDao sportDao) {
            this.sportDao = sportDao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            sportDao.insertSports(sports);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao sportDao;

        UpdateAsyncTask(SportDao sportDao) {
            this.sportDao = sportDao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            sportDao.updateSports(sports);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDao sportDao;

        DeleteAsyncTask(SportDao sportDao) {
            this.sportDao = sportDao;
        }

        @Override
        protected Void doInBackground(Sport... sports) {
            sportDao.deleteSports(sports);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private SportDao sportDao;

        DeleteAllAsyncTask(SportDao sportDao) {
            this.sportDao = sportDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            sportDao.deleteAllSports();
            return null;
        }
    }
}
