package com.padcmyanmar.simple_habits_mma.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.simple_habits_mma.data.vos.CurrentProgramVO;

public class CurrentProgramResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgramVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgramVO() {
        return currentProgramVO;
    }
}
