package com.example.a20220622juanmartinezleonnycschools.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.repository.SchoolRepository;
import com.example.a20220622juanmartinezleonnycschools.response.SchoolResponse;

import java.util.List;

public class SchoolViewModel extends AndroidViewModel {

    private SchoolRepository schoolRepository;
    private LiveData<List<School>> schoolResponseLiveData;

    public SchoolViewModel(@NonNull Application application) {

        super(application);
        this.schoolRepository = new SchoolRepository();
        this.schoolResponseLiveData = schoolRepository.getSchools(null);
    }

    public void getSchools(String cityName) {
        this.schoolResponseLiveData = schoolRepository.getSchools(cityName);
    }

    public LiveData<List<School>> getSchoolResponseLiveData() {
        return schoolResponseLiveData;
    }
}
