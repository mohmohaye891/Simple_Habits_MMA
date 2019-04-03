package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;

public interface CurrentProgramModel {

    CurrentProgramVO getCurrentProgram(String accessToken, CurrentProgramDelegate delegate);

    interface CurrentProgramDelegate {
        void onSuccess(CurrentProgramVO currentProgram);
        void onFail(String errorMsg);
    }
}
