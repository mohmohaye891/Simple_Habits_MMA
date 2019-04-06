package com.padcmyanmar.simple_habits_mma.data.models;

import android.content.Context;

import com.padcmyanmar.simple_habits_mma.data.vos.TopicsVO;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.network.DataAgent;
import com.padcmyanmar.simple_habits_mma.network.RetrofitDA;

import java.util.ArrayList;
import java.util.List;

public class TopicsModelImpl extends BaseModel implements TopicsModel {

    private static TopicsModelImpl objInstance;

   /* private DataAgent mDataAgent;

    private List<TopicsVO> mTopics;*/

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    public TopicsModelImpl(Context context) {
        super(context);
    }

    public static void initTopicsModel(Context context) {
        objInstance = new TopicsModelImpl(context);
    }


    public static TopicsModelImpl getObjInstance() {

        if (objInstance == null) {

            throw new RuntimeException("TopicModelImpl should have been initialized before using it.");

        }
        return objInstance;
    }



    @Override
    public List<TopicsVO> getTopics(String accessToken, final TopicsDelegate topicDelegate) {

        if (mDataBase.isTopicsEmpty()) {
            mDataAgent.getTopics(DUMMY_ACCESS_TOKEN, 1, new TopicsDelegate() {
                @Override
                public void onSuccess(List<TopicsVO> topicsData) {
                    long[] topicsId = mDataBase.topicDao().insertTopics(topicsData);
                    List<TopicsVO> topicDB = mDataBase.topicDao().getAllTopics();
                    topicDelegate.onSuccess(topicDB);
                }

                @Override
                public void onFail(String errorMsg) {
                    topicDelegate.onFail(errorMsg);

                }
            });
        }else {
            List<TopicsVO> topicsList = mDataBase.topicDao().getAllTopics();
            return topicsList;
        }
        return null;
    }
}
