package com.example.a20220622juanmartinezleonnycschools.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a20220622juanmartinezleonnycschools.Retrofit.ApiRequest;
import com.example.a20220622juanmartinezleonnycschools.Retrofit.RetrofitRequest;
import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.model.Scores;
import com.example.a20220622juanmartinezleonnycschools.response.SchoolResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolRepository {

    private final ApiRequest apiRequest;

    public SchoolRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<School>> getSchools(String cityName) {
        final MutableLiveData<List<School>> data = new MutableLiveData<>();
        apiRequest.getSchools(cityName).enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                Log.d("state", response.body().toString());
                if (response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.d("state", "failed");
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<List<Scores>> getScores(String dbn) {
        final MutableLiveData<List<Scores>> data = new MutableLiveData<>();
        apiRequest.getScores(dbn).enqueue(new Callback<List<Scores>>() {

            @Override
            public void onResponse(Call<List<Scores>> call, Response<List<Scores>> response) {
                Log.d("state", response.body().toString());
                if (response.body() != null)
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Scores>> call, Throwable t) {
                Log.d("state", "failed");
                data.setValue(null);
            }
        });
        return data;
    }
}
