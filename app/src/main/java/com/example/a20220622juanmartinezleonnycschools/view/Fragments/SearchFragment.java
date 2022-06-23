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
import com.example.a20220622juanmartinezleonnycschools.databinding.SearchBinding;
import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.view.Adapter.SchoolAdapter;
import com.example.a20220622juanmartinezleonnycschools.view_model.SchoolViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private SearchBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SearchBinding.inflate(getLayoutInflater());

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String cityName = binding.tiCityName.getText().toString();
                NavDirections action =
                        SearchFragmentDirections.actionSearchToList(cityName);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return binding.getRoot();
    }
}