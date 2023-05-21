package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.medical.adapter.DepartmentAdapter;
import com.example.medical.adapter.DoctorAdapter;
import com.example.medical.model.Department;
import com.example.medical.model.Doctor;
import com.example.medical.service.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorList extends AppCompatActivity {
    RecyclerView recyclerView;
    DoctorAdapter adapter;
    TextView nameDepartment, deDepartment;

    /*
        use case 2 Đăng ký lịch khám mới
        6. onCreate()
    */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("departmentInfo");
        nameDepartment = findViewById(R.id.name_department_doctor);
        nameDepartment.setText(bundle.getString("name"));
        deDepartment = findViewById(R.id.dec_department_doctor);
        deDepartment.setText(bundle.getString("dec"));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.doctor_list);
        recyclerView.setLayoutManager(layout);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new DoctorAdapter();
        showList(bundle.getString("id"));
    }
    /*
     use case 2 Đăng ký lịch khám mới
     6.3 showList(departmentId)
    */
    public void showList(String departmentId) {
        /*
            use case 2 Đăng ký lịch khám mới
            6.1 Get: /api/v1/Doctors/{departmentId}
        */
        Call<List<Doctor>> call = ApiClient.getApiService().getAllDoctorByDepartmentId(departmentId);
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                if (response.isSuccessful()) {
                    Log.e("successful", response.body().toString());
                    List<Doctor> doctors = response.body();
                    adapter.setData(doctors);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                Log.e("fail", "Lỗi ko lấy được");
            }
        });
    }
}