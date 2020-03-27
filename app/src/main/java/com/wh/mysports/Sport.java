package com.wh.mysports;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sport {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "start_time_ms")
    private long startTimeYear;

    @ColumnInfo(name = "count")
    private int count;

    Sport(String type, long startTimeYear, int count) {
        this.type = type;
        this.startTimeYear = startTimeYear;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getStartTimeYear() {
        return startTimeYear;
    }

    public void setStartTimeYear(long startTimeYear) {
        this.startTimeYear = startTimeYear;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

// id type start_time count(几个或者几秒)