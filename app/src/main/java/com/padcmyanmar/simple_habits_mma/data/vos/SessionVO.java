package com.padcmyanmar.simple_habits_mma.data.vos;

import com.google.gson.annotations.SerializedName;

public class SessionVO {

    @SerializedName("session-id")
    private String sessionId;

    @SerializedName("title")
    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }
}
