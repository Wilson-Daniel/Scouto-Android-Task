package com.example.GarageAppWilson;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.GarageAppWilson.Class.userData;

@Database(entities = userData.class, exportSchema = false, version = 1)
public abstract class UserHelperDatabase extends RoomDatabase {

    private static final String UserDB_NAME = "userDatabaseTable";
    public static UserHelperDatabase instanc;

    public static synchronized UserHelperDatabase getDB(Context context) {
        if(instanc == null) {
            instanc = Room.databaseBuilder(context, UserHelperDatabase.class, UserDB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instanc;
    }
    public abstract UserDao userDao();
}
