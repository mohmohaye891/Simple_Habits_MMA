package com.padcmyanmar.simple_habits_mma.data.models;

import android.content.Context;
import android.util.Log;

import com.padcmyanmar.simple_habits_mma.data.vos.LoginUserVO;
import com.padcmyanmar.simple_habits_mma.delegates.LoginDelegate;

public class UserModelImpl extends BaseModel implements UserModel {

    private static UserModel instance;

    private LoginUserVO mLoginUser;

    private UserModelImpl(Context context) {

        super(context);
    }

    public static void initUserModel(Context context) {
        instance = new UserModelImpl(context);
    }


    public static UserModel getInstance() {
        if (instance == null) {
            throw new RuntimeException("USerModel should have been initialized before using it");
        }
        return instance;

    }

    @Override
    public void login(String emailOrPassword, String password, final LoginDelegate loginDelegate) {
   /*     mDataAgent.login(emailOrPassword, password, new LoginDelegate() {
            @Override
            public void onSuccess(LoginUserVO loginUser) {
                mLoginUser = loginUser;
                long userID =  mDataBase.loginUserDao().insertLoginUser(loginUser);
                Log.d("", "userID" + userID);
                loginDelegate.onSuccess(loginUser);
            }

            @Override
            public void onFail(String msg) {
                loginDelegate.onFail(msg);
            }
        });*/

        mLoginUser = new LoginUserVO();
        mLoginUser.setEmail(emailOrPassword);
        mLoginUser.setPhoneNo(password);
        long userID =  mDataBase.loginUserDao().insertLoginUser(mLoginUser);
        Log.d("", "userID" + userID);
        loginDelegate.onSuccess(mLoginUser);

    }

    @Override
    public void onUserLogout() {
        mDataBase.loginUserDao().deleteLoginUser();
    }


    @Override
    public LoginUserVO getLoginUser() {

        LoginUserVO loginUser =  mDataBase.loginUserDao().getLoginUser();
        return loginUser;
    }

    @Override
    public boolean isUserdLogin() {
        return mDataBase.loginUserDao().getLoginUser() != null;
    }
}
