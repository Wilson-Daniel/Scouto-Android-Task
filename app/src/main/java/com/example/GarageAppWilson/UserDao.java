package com.example.GarageAppWilson;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.GarageAppWilson.Class.userData;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(userData userData);
    @Delete
    void deleteUser(userData userData);

    @Query("SELECT * FROM userDatabaseTable")
    List<userData> getUserData();

    @Query("SELECT id,userid FROM userDatabaseTable WHERE id = :num")
    public List<userData> loadUserid(int num);


    @Query("SELECT id,userid,password FROM userDatabaseTable WHERE id = :uid")
    public List<userData> loadPassword(String uid);



}
