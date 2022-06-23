package com.example.a20220622juanmartinezleonnycschools.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.model.Scores;
import com.example.a20220622juanmartinezleonnycschools.repository.SchoolRepository;

import java.util.List;

public class ScoresViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;
    private LiveData<List<Scores>> scoresResponseLiveData;

    public ScoresViewModel(@NonNull Application application) {

        super(application);
        this.schoolRepository = new SchoolRepository();
        this.scoresResponseLiveData = schoolRepository.getScores(null);
    }

    public void getScores(String dbn) {
        this.scoresResponseLiveData = schoolRepository.getScores(dbn);
    }


    public LiveData<List<Scores>> getSchoolResponseLiveData() {
        return scoresResponseLiveData;
    }
}
