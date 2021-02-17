package com.example.taskprofutenti.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import javax.xml.namespace.QName;

@Dao
public interface UserDAO {


    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("UPDATE user SET First_name=:name,Last_name=:lastName,Age=:age WHERE First_name=:nomeR")
    void updateUser(String name, String lastName, String age, String nomeR);

    @Delete
    void delete(User u);

    @Insert
    void insertAll(User... users);

}
