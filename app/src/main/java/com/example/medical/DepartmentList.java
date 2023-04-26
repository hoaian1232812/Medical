package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.medical.adapter.DepartmentAdapter;
import com.example.medical.model.Department;
import com.example.medical.service.ApiService;
import com.example.medical.service.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentList extends AppCompatActivity {
    RecyclerView recyclerView;
    DepartmentAdapter adapter;
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.department_list);
        recyclerView.setLayoutManager(layout);
        showList();
    }

    private void showList(){
        service = new Service();
        ApiService apiService = service.createRetrofit("http://localhost:8080/");
        Call<List<Department>> call = apiService.listDepartment();
        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if(response.isSuccessful()) {
                    List<Department> departments = response.body();
                    adapter = new DepartmentAdapter(departments);
                    recyclerView.setAdapter(adapter);
                    Log.d("Size", ""+departments.size());
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {

            }
        });
    }
}