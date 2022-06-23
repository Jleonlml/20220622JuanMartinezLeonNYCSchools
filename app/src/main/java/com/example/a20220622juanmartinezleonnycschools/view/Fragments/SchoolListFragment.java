package com.example.a20220622juanmartinezleonnycschools.view.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20220622juanmartinezleonnycschools.databinding.SchoolsListBinding;
import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.view.Adapter.SchoolAdapter;
import com.example.a20220622juanmartinezleonnycschools.view_model.SchoolViewModel;

import java.util.ArrayList;
import java.util.List;

public class SchoolListFragment extends Fragment {
    private SchoolsListBinding binding;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<School> schoolArrayList = new ArrayList<>();
    SchoolViewModel schoolViewModel;
    private SchoolAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SchoolsListBinding.inflate(getLayoutInflater());

        init();
        getSchools();

        return binding.getRoot();
    }

    private void getSchools() {

        schoolViewModel.getSchoolResponseLiveData().observe(getViewLifecycleOwner(), schoolResponse -> {

            if(schoolResponse != null && schoolResponse != null && !schoolResponse.isEmpty())
            {
                List<School> schoolList = schoolResponse;
                schoolArrayList.addAll(schoolList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void openDetails(School school, View view) {
        NavDirections action =
                SchoolListFragmentDirections.actionListToSchoolDetails(school);
        Navigation.findNavController(view).navigate(action);
    }

    private void init() {
        String cityName = getArguments().getString("cityName");
        recyclerView = binding.rvSchools;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SchoolAdapter(getActivity(), schoolArrayList, this, new SchoolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(School school, View view) {
                openDetails(school, view);
            }
        });

        recyclerView.setAdapter(adapter);
        schoolViewModel = new ViewModelProvider(requireActivity()).get(SchoolViewModel.class);
        schoolViewModel.getSchools(cityName);
    }
}