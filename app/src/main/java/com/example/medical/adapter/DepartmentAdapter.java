package com.example.medical.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.medical.DoctorInfo;
import com.example.medical.DoctorList;
import com.example.medical.R;
import com.example.medical.model.Department;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentVH> {
    private List<Department> departments;
    private Context context;

    public DepartmentAdapter() {

    }

    public void setData(List<Department> newData){
        this.departments = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DepartmentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false);
        return new DepartmentVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentVH holder, int position) {
        Department department = departments.get(position);
        Glide.with(holder.image.getContext()).load(department.getUrl()).into(holder.image);
        holder.name.setText(department.getName());
          /*
            use case 2 Đăng ký lịch khám mới
            5. Chọn một khoa
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DoctorList.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", department.getId());
                bundle.putString("name", department.getName());
                bundle.putString("dec", department.getDecription());
                intent.putExtra("departmentInfo", bundle);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    class DepartmentVH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public DepartmentVH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_department);
            name = itemView.findViewById(R.id.name_department);
        }
    }
}
