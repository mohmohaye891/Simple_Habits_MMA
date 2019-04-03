package com.padcmyanmar.simple_habits_mma.delegates;

import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;
import com.padcmyanmar.simple_habits_mma.network.responses.CurrentProgramResponse;

import java.util.List;

public interface CurrentProgramDelegate {

    void onSuccess(CurrentProgramVO currentPrograms);

    void onFail(String Msg);
}
