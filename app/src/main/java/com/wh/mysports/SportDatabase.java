package com.wh.mysports;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sport.class},version = 1,exportSchema = false)
abstract class SportDatabase extends RoomDatabase {
    private static SportDatabase INSTANCE;
    static synchronized SportDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),SportDatabase.class,"sport_database")
                    .build();
        }
        return INSTANCE;
    }

    abstract SportDao getSportDao();
}
