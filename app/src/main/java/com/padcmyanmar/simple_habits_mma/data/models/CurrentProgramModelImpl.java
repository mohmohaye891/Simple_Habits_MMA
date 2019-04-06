package com.padcmyanmar.simple_habits_mma.data.models;

import android.content.Context;

import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;

public class CurrentProgramModelImpl extends BaseModel implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    public CurrentProgramModelImpl(Context context) {
        super(context);
    }


    public static void initCurrentProgramModel(Context context){
        objInstance = new CurrentProgramModelImpl(context);
    }

    public static CurrentProgramModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException("CurrentProgramImpl should have been initialized before using it.");
        }
        return objInstance;
    }


    @Override
    public CurrentProgramVO getCurrentProgram(String accessToken, final CurrentProgramDelegate delegate) {

        if (mDataBase.isCurrentProgramEmpty()) {
            mDataAgent.getCurrentProgram(DUMMY_ACCESS_TOKEN, 1, new CurrentProgramDelegate() {
                @Override
                public void onSuccess(CurrentProgramVO data) {

                   long currentProgram = mDataBase.currentProgramDao().insertCurrentProgram(data);
                   CurrentProgramVO currentProgramVO = mDataBase.currentProgramDao().getCurrentProgram();
                   delegate.onSuccess(currentProgramVO);
                }

                @Override
                public void onFail(String Msg) {

                    delegate.onFail(Msg);
                }
            });
        }else {
            CurrentProgramVO currentProgram = mDataBase.currentProgramDao().getCurrentProgram();
            return currentProgram;
        }
        return null;
    }
}
