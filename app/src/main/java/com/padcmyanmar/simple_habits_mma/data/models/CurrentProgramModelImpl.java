package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simple_habits_mma.network.DataAgent;

public class CurrentProgramModelImpl implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    private DataAgent mDataAgent;

    private CurrentProgramVO currentProgram;

    public CurrentProgramModelImpl() {
        mDataAgent = mDataAgent;
    }

    public static CurrentProgramModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new CurrentProgramModelImpl();
        }
        return objInstance;
    }

    @Override
    public CurrentProgramVO getCurrentProgram(String accessToken, final CurrentProgramDelegate delegate) {

        if (currentProgram == null) {
            mDataAgent.getCurrentProgram(accessToken, 1, new com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate() {
                @Override
                public void onSuccess(CurrentProgramVO currentProgramsData) {
                    currentProgram = currentProgramsData;
                    delegate.onSuccess(currentProgramsData);
                }

                @Override
                public void onFail(String Msg) {
                    delegate.onFail(Msg);
                }
            });
        }

        return null;
    }
}
