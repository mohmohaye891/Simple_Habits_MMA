package com.padcmyanmar.simple_habits_mma.network;

import com.google.gson.Gson;
import com.padcmyanmar.simple_habits_mma.data.models.TopicsModel;
import com.padcmyanmar.simple_habits_mma.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.ProgramDelegate;
import com.padcmyanmar.simple_habits_mma.delegates.TopicsDelegate;
import com.padcmyanmar.simple_habits_mma.network.responses.CategoriesProgramsResponse;
import com.padcmyanmar.simple_habits_mma.network.responses.CurrentProgramResponse;
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

    @Override
    public void getCategoryProgram(String accessToken, int page, final CategoryProgramDelegate categoryProgramDelegate) {
        Call<CategoriesProgramsResponse> categoriesProgramsResponseCall = mApi.getCategoryProgramResponse(accessToken, page);
        categoriesProgramsResponseCall.enqueue(new Callback<CategoriesProgramsResponse>() {
            @Override
            public void onResponse(Call<CategoriesProgramsResponse> call, Response<CategoriesProgramsResponse> response) {
                CategoriesProgramsResponse categoriesProgramsResponse = response.body();
                if (categoriesProgramsResponse.isSuccess()) {
                    categoryProgramDelegate.onSuccess(categoriesProgramsResponse.getCategoryPrograms());
                } else {
                    categoryProgramDelegate.onFail(categoriesProgramsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<CategoriesProgramsResponse> call, Throwable t) {
                categoryProgramDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramDelegate currentProgramDelegate) {
        Call<CurrentProgramResponse> currentProgramResponseCall = mApi.getCurrentProgramResponse(accessToken, page);
        currentProgramResponseCall.enqueue(new Callback<CurrentProgramResponse>() {
            @Override
            public void onResponse(Call<CurrentProgramResponse> call, Response<CurrentProgramResponse> response) {
                CurrentProgramResponse currentProgramResponse = response.body();
                if (currentProgramResponse.isSuccess()){
                    currentProgramDelegate.onSuccess(currentProgramResponse.getCurrentProgramVO());
                }else {
                    currentProgramDelegate.onFail(currentProgramResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<CurrentProgramResponse> call, Throwable t) {
                currentProgramDelegate.onFail(t.getMessage());
            }
        });
    }

}
