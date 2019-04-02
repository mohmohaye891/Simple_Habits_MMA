package com.padcmyanmar.simple_habits_mma.data.vos;

import com.google.gson.annotations.SerializedName;

public class TopicsVO {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("icon")
    private String icon;

    @SerializedName("background")
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }
}
