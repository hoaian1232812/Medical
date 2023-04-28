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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.medical.DoctorInfo;
import com.example.medical.R;
import com.example.medical.model.Department;
import com.example.medical.model.Doctor;

import java.util.List;
import java.util.zip.Inflater;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorVH> {
    private List<Doctor> doctors;
    private Context context;

    @NonNull
    @Override
    public DoctorVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item, parent, false);
        return new DoctorVH(itemView);
    }

    public void setData(List<Doctor> newData) {
        this.doctors = newData;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorVH holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.name.setText(doctor.getName());
        holder.rating.setText("" + doctor.getRating());
        holder.price.setText(holder.price.getText().toString() + doctor.getFee() + "Đ");
        Glide.with(holder.img.getContext())
                .load(doctor.getUrlPhoto())
                .transform(new CircleCrop())
                .into(holder.img);
          /*
            use case 2 Đăng ký lịch khám mới
            7. Chọn một bác sĩ
        */
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DoctorInfo.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("doctor", doctor);
            intent.putExtra("doctorInfo", bundle);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    class DoctorVH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, rating, price;

        public DoctorVH(@NonNull View itemView) {
            super(itemView);
            this.img = itemView.findViewById(R.id.image_doctor);
            this.name = itemView.findViewById(R.id.name_doctor);
            this.rating = itemView.findViewById(R.id.rating_doctor);
            this.price = itemView.findViewById(R.id.price_doctor);
        }
    }
}
