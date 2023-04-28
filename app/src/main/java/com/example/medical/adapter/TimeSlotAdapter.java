package com.example.medical.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medical.AppointmentForm;
import com.example.medical.R;
import com.example.medical.model.Doctor;
import com.example.medical.model.Schedule;
import com.example.medical.model.TimeSlot;

import java.util.List;
import java.util.Scanner;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotVH> {
    List<TimeSlot> list;
    Context context;
    Doctor doctor;
    Schedule schedule;

    @NonNull
    @Override
    public TimeSlotVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_item, parent, false);
        return new TimeSlotVH(itemView);
    }

    public void setData(List<TimeSlot> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotVH holder, int position) {
        TimeSlot timeSlot = this.list.get(position);
        holder.text.setText(timeSlot.getTime());
          /*
            use case 2 Đăng ký lịch khám mới
             11. Chọn thời gian khám
        */
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AppointmentForm.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("doctor", doctor);
            bundle.putSerializable("schedule", schedule);
            bundle.putSerializable("time", timeSlot);
            intent.putExtra("data", bundle);
            view.getContext().startActivity(intent);
        });
    }

    public void setIntent(Doctor d, Schedule s) {
        doctor = d;
        schedule = s;
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class TimeSlotVH extends RecyclerView.ViewHolder {
        TextView text;

        public TimeSlotVH(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.timeSlot);
        }
    }
}
