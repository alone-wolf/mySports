package com.wh.mysports;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SportDao {

    @Insert
    void insertSports(Sport... sports);

    @Update
    void updateSports(Sport... sports);

    @Delete
    void deleteSports(Sport... sports);

    @Query("delete from SPORT")
    void deleteAllSports();

    @Query("select * from SPORT order by id desc")
    LiveData<List<Sport>>getAllSportsLive();
}
