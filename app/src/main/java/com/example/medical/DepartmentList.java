package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.medical.adapter.DepartmentAdapter;
import com.example.medical.model.Department;
import com.example.medical.service.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentList extends AppCompatActivity {
    RecyclerView recyclerView;
    DepartmentAdapter adapter;

    /*
        use case 2 Đăng ký lịch khám mới
        4. onCreate()
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(DepartmentList.this);
        recyclerView = findViewById(R.id.department_list);
        recyclerView.setLayoutManager(layout);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new DepartmentAdapter();
        showList();

    }

    /*
        use case 2 Đăng ký lịch khám mới
        4.3 showList()
    */
    private void showList() {
        /*
            use case 2 Đăng ký lịch khám mới
            4.1 Get: /api/v1/Departments
        */
        Call<List<Department>> call = ApiClient.getApiService().getAll();
        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if (response.isSuccessful()) {
                    List<Department> departments = response.body();
                    adapter.setData(departments);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                Log.e("fail", "Lỗi ko lấy được");
            }
        });
    }
}