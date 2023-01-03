package com.example.medicare;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
//DATA ACCESS OBJECT
public interface UserDAO {

    @Insert
    void RegisterUser(UserEntity userEntity);

    @Query("SELECT * from users where input_username = (:username) and input_password = (:password)")
    UserEntity login(String username, String password);
}
