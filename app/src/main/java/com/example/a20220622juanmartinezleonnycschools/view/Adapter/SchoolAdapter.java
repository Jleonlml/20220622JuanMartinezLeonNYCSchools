package com.example.a20220622juanmartinezleonnycschools.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20220622juanmartinezleonnycschools.R;
import com.example.a20220622juanmartinezleonnycschools.model.School;
import com.example.a20220622juanmartinezleonnycschools.view.Fragments.SchoolListFragment;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(School school, View view);
    }

    private final Context context;
    ArrayList<School> schoolsArrayList;
    private final SchoolListFragment schoolListFragment;
    private final OnItemClickListener listener;


    public SchoolAdapter(Context context, ArrayList<School> schoolsArrayList, SchoolListFragment fragment, OnItemClickListener listener) {
        this.context = context;
        this.schoolsArrayList = schoolsArrayList;
        this.schoolListFragment = fragment;
        this.listener = listener;
    }


    @NonNull
    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder holder, int position) {
        holder.bind(schoolsArrayList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return schoolsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSchoolName;
        private final TextView tvLocation;
        private final TextView tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSchoolName = itemView.findViewById(R.id.tvShoolName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }

        public void bind(final School school, final OnItemClickListener listener) {
            tvSchoolName.setText(school.schoolName);
            tvLocation.setText(school.location);
            tvEmail.setText(school.schoolEmail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(school, v);
                }
            });
        }
    }
}
