package com.padcmyanmar.simple_habits_mma.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "topic", indices = {@Index(value = {"topic_name"}, unique = true)})
public class TopicsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "topic_name_pk")
    private int topicIdPk;

    @ColumnInfo(name = "topic_name")
    @SerializedName("topic-name")
    private String topicName;

    @ColumnInfo(name = "topic_desc")
    @SerializedName("topic-desc")
    private String topicDesc;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    private String icon;

    @ColumnInfo(name = "background")
    @SerializedName("background")
    private String background;

    public int getTopicIdPk() {
        return topicIdPk;
    }

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

    public void setTopicIdPk(int topicIdPk) {
        this.topicIdPk = topicIdPk;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
