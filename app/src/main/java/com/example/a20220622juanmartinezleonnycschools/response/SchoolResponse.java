package com.example.a20220622juanmartinezleonnycschools.response;

import com.example.a20220622juanmartinezleonnycschools.model.School;

import java.util.List;

public class SchoolResponse {

    private List<School> schools;

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }
}
