package com.example.a20220622juanmartinezleonnycschools.Retrofit;

import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.model.Scores;
import com.example.a20220622juanmartinezleonnycschools.response.SchoolResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("resource/s3k6-pzi2.json")
    Call<List<School>> getSchools(
            @Query("city") String cityName
    );

    @GET("resource/f9bf-2cp4.json")
    Call<List<Scores>> getScores(
            @Query("dbn") String dbn
            );
}
