package com.example.a20220622juanmartinezleonnycschools.view.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20220622juanmartinezleonnycschools.databinding.SchoolDetailsBinding;
import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.view_model.ScoresViewModel;

public class DetailsFragment extends Fragment {
    private SchoolDetailsBinding binding;
    ScoresViewModel scoresViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SchoolDetailsBinding.inflate(getLayoutInflater());

        init();
        getScores();

        return binding.getRoot();
    }

    private void getScores() {

        scoresViewModel.getSchoolResponseLiveData().observe(getViewLifecycleOwner(), scoresResponse -> {

            if(scoresResponse != null && scoresResponse != null && !scoresResponse.isEmpty())
            {
                binding.tvReadScore.setText(scoresResponse.get(0).readingScore.toString());
                binding.tvWriteScore.setText(scoresResponse.get(0).writingScore.toString());
                binding.tvMathScore.setText(scoresResponse.get(0).mathScore.toString());
            }
        });
    }

    private void init() {
        School school = (School) getArguments().getSerializable("school");
        binding.tvSchoolName.setText(school.schoolName);
        binding.tvLocation.setText(school.location);
        binding.tvPhone.setText(school.phoneNumber);
        binding.tvEmail.setText(school.schoolEmail);
        binding.tvOverview.setText(school.overviewParagraph);
        scoresViewModel = new ViewModelProvider(requireActivity()).get(ScoresViewModel.class);
        scoresViewModel.getScores(school.dbn);
    }

}