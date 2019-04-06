package com.padcmyanmar.simple_habits_mma.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "current_program",indices = {@Index(value = {"program_id"}, unique = true)})
public class CurrentProgramVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "program_id_pk")
    private int programIdPK;

    @ColumnInfo(name = "program_id")
    @SerializedName("program-id")
    private String programID;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "background")
    @SerializedName("background")
    private String image;

    @Ignore
    @SerializedName("average-lengths")
    private List<Integer> averageLength;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "current-period")
    @SerializedName("current-period")
    private String currentPeriod;

    @Ignore
    @SerializedName("sessions")
    private List<SessionVO> session;

    public int getProgramIdPK() {
        return programIdPK;
    }

    public String getProgramID() {
        return programID;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getAverageLength() {
        return averageLength;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public List<SessionVO> getSession() {
        return session;
    }

    public void setProgramIdPK(int programIdPK) {
        this.programIdPK = programIdPK;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAverageLength(List<Integer> averageLength) {
        this.averageLength = averageLength;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public void setSession(List<SessionVO> session) {
        this.session = session;
    }
}
