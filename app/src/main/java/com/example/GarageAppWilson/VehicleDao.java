package com.example.GarageAppWilson;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface VehicleDao {

    @Insert
    void addTx(carData cardata);

    @Update
    void updataTx(carData cardata);

    @Delete
    void deleteTx(carData cardata);

    @Query("DELETE FROM vehicledatabase WHERE id = :did")
    void deleteById(int did);


    @Query("SELECT * FROM vehicledatabase")
    List<carData> getAllData();
    //LiveData<List<CarData>> getAllData();
}
