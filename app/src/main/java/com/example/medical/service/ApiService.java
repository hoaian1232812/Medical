package com.example.medical.service;

import com.example.medical.model.Department;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/v1/Departments")
    Call<List<Department>> getAll();
}
