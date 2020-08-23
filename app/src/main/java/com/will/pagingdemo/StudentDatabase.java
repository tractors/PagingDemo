package com.will.pagingdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static volatile StudentDatabase instance;
    static final Byte[] bytes = new Byte[9];

    private StudentDatabase() {
    }

    static StudentDatabase getInstance(Context context){
        if (instance == null){
            synchronized (bytes){
                if (instance == null){
                    instance = Room.databaseBuilder(context,StudentDatabase.class,"student_database").build();
                }
            }
        }
        return instance;
    }

    abstract StudentDao getStudentDao();
}
