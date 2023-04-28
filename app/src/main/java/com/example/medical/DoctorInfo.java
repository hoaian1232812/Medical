package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.medical.adapter.TimeSlotAdapter;
import com.example.medical.model.Doctor;

public class DoctorInfo extends AppCompatActivity {
    ImageView img;
    TextView name, dec, rating, price;
    Spinner spinner;
    RecyclerView recyclerView;
    Doctor doctor;
    TimeSlotAdapter adapter;


    /*
   use case 2 Đăng ký lịch khám mới
   8. onCreate()
  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_info);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("doctorInfo");
        doctor = (Doctor) bundle.get("doctor");
        img = findViewById(R.id.image_info);
        Glide.with(img.getContext())
                .load(doctor.getUrlPhoto())
                .transform(new CircleCrop())
                .into(img);
        name = findViewById(R.id.name_info);
        name.setText(doctor.getEducation() + " " + doctor.getName());
        rating = findViewById(R.id.rating_info);
        rating.setText("" + doctor.getRating());
        price = findViewById(R.id.price_info);
        price.setText(price.getText().toString() + doctor.getFee());
        setRecyclerView();
        showSpinner();
        dec = findViewById(R.id.de_info);
        dec.setText(doctor.getDescription());
    }

    public void showSpinner() {
        spinner = findViewById(R.id.spinner_info);
        String[] items = doctor.getWorkDate();
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(
                this,
                R.layout.spiner_item,
                items
        );
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
          /*
            use case 2 Đăng ký lịch khám mới
            9. Chọn ngày khám
            */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  /*
                    use case 2 Đăng ký lịch khám mới
                    10. setData(listTimeSlot)
                   */
                adapter.setData(doctor.getSchedules().get(position).getTimeSlots());
                adapter.setIntent(doctor, doctor.getSchedules().get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setRecyclerView() {
        recyclerView = findViewById(R.id.time_recycle);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new TimeSlotAdapter();
        adapter.setData(doctor.getSchedules().get(0).getTimeSlots());
        recyclerView.setAdapter(adapter);
    }
}