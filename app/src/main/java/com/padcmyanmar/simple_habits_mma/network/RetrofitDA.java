package com.padcmyanmar.simple_habits_mma.network;

import com.google.gson.Gson;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModel;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.network.responses.TopicsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements DataAgent {

    private static RetrofitDA objInstance;

    private SimpleHabitAPI mApi;

    public static RetrofitDA getObjInstance() {
        if (objInstance == null) {

            objInstance = new RetrofitDA();
        }
        return objInstance;
    }

    private RetrofitDA() {
        final OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mApi = retrofit.create(SimpleHabitAPI.class);
    }


    @Override
    public void getTopics(String accessToken, int page, final TopicsDelegate topicsDelegate) {

        Call<TopicsResponse> topicsResponseCall = mApi.getTopics(accessToken, page);
        topicsResponseCall.enqueue(new Callback<TopicsResponse>() {
            @Override
            public void onResponse(Call<TopicsResponse> call, Response<TopicsResponse> response) {
                TopicsResponse topicsResponse = response.body();
                if (topicsResponse.isSuccess()) {
                    topicsDelegate.onSuccess(topicsResponse.getTopics());
                }else {
                    topicsDelegate.onFail(topicsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<TopicsResponse> call, Throwable t) {

                topicsDelegate.onFail(t.getMessage());
            }
        });
    }
}
