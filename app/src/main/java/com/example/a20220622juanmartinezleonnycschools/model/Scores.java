package com.example.a20220622juanmartinezleonnycschools.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Scores implements Serializable{
    @SerializedName("sat_critical_reading_avg_score") public Integer readingScore;
    @SerializedName("sat_math_avg_score") public Integer mathScore;
    @SerializedName("sat_writing_avg_score") public Integer writingScore;

    public Integer getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(Integer readingScore) {
        this.readingScore = readingScore;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(Integer writingScore) {
        this.writingScore = writingScore;
    }
}
