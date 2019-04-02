package com.padcmyanmar.simple_habits_mma.delegates;

import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;

import java.util.List;

public interface TopicsDelegate {

    void onSuccess(List<TopicsVO> topics);

    void onFail(String error);
}
