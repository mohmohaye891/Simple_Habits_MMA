package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.LoginUserVO;
import com.padcmyanmar.simple_habits_mma.delegates.LoginDelegate;

public interface UserModel {

    void login(String emailOrPassword, String password, LoginDelegate loginDelegate);

    void onUserLogout();

    LoginUserVO getLoginUser();

    boolean isUserdLogin();
}
