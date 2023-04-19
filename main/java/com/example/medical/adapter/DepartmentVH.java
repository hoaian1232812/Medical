package com.example.medical.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medical.R;

public class DepartmentVH extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name;

    public DepartmentVH(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image_department);
        name = itemView.findViewById(R.id.name_department);
    }
}
