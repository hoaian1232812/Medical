package com.example.medical.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.medical.R;
import com.example.medical.model.Department;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentVH>{
    private List<Department> departments;

    public DepartmentAdapter(List<Department> departments) {
        this.departments = departments;
    }

    @NonNull
    @Override
    public DepartmentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item,parent,false);
        return new DepartmentVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentVH holder, int position) {
        Department department = departments.get(position);
        Glide.with(holder.image.getContext()).load(department.getUrl()).into(holder.image);
        holder.name.setText(department.getName());
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }
}
