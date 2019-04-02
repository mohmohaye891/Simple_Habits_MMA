package com.padcmyanmar.simple_habits_mma.data.models;

import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.network.DataAgent;
import com.padcmyanmar.simple_habits_mma.network.RetrofitDA;

import java.util.ArrayList;
import java.util.List;

public class TopicsModelImpl implements TopicsModel {

    private static TopicsModelImpl objInstance;

    private DataAgent mDataAgent;

    private List<TopicsVO> mTopics;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private TopicsModelImpl() {
        mTopics = new ArrayList<>();
        mDataAgent = RetrofitDA.getObjInstance();
    }

    public static TopicsModelImpl getObjInstance() {

        if (objInstance == null) {

            objInstance = new TopicsModelImpl();

        }
        return objInstance;
    }



    @Override
    public List<TopicsVO> getTopics(String accessToken, final TopicsDelegate topicDelegate) {

        if (mTopics.isEmpty()) {
            mDataAgent.getTopics(DUMMY_ACCESS_TOKEN, 1, new TopicsDelegate() {
                @Override
                public void onSuccess(List<TopicsVO> topicsData) {
                    mTopics = topicsData;
                    topicDelegate.onSuccess(topicsData);
                }

                @Override
                public void onFail(String errorMsg) {
                    topicDelegate.onFail(errorMsg);

                }
            });
        }
        return mTopics;
    }
}
