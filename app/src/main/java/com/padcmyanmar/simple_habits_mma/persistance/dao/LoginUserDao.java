package com.padcmyanmar.simple_habits_mma.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.padcmyanmar.simple_habits_mma.data.vos.LoginUserVO;

@Dao
public interface LoginUserDao {

   // void insertLoginUser (LoginUserVO loginUser);

    @Insert
    long insertLoginUser(LoginUserVO loginUser);


    @Query("SELECT * FROM login_user")
    LoginUserVO getLoginUser();

    @Query("DELETE FROM login_user")
    void deleteLoginUser();



}
