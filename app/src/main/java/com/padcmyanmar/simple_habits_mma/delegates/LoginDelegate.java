package com.padcmyanmar.simple_habits_mma.delegates;

import com.padcmyanmar.simple_habits_mma.data.vos.LoginUserVO;

public interface LoginDelegate extends BaseNetworkDelegate {

    void onSuccess(LoginUserVO loginUser);
}
