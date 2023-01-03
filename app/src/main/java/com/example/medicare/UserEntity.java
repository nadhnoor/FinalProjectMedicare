package com.example.medicare;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//CREATE TABLE DATABASE
@Entity(tableName = "users")
public class UserEntity{

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "input_username")
    String username;

    @ColumnInfo(name = "input_password")
    String password;

    @ColumnInfo(name = "input_fullname")
    String fullname;

    @ColumnInfo(name = "input_phone")
    String phone;

    @ColumnInfo(name = "input_email")
    String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
