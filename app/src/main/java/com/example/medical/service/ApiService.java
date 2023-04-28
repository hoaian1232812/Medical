package com.example.medical.service;

import com.example.medical.model.Appointment;
import com.example.medical.model.Department;
import com.example.medical.model.Doctor;
import com.example.medical.model.Patient;
import com.example.medical.model.ResponseObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {
    /*
       use case 2 Đăng ký lịch khám mới
       4.1 Get: /api/v1/Departments
    */
    @GET("/api/v1/Departments")
    Call<List<Department>> getAll();

    /*
       use case 2 Đăng ký lịch khám mới
       6.1 Get: /api/v1/Doctors/{departmentId}
    */
    @GET("/api/v1/Doctors/{departmentId}")
    Call<List<Doctor>> getAllDoctorByDepartmentId(@Path("departmentId") String departmentId);

    @POST("/api/v1/savePatient")
    Call<Patient> addPatientDB(@Body Patient patient);

    @GET("/api/v1/Patient/{id}")
    Call<ResponseObject> getPatientById(@Path("id") String id);
    /*
       use case 2 Đăng ký lịch khám mới
       16. Post: api/v1/
     */
    @POST("/api/v1/saveAppointment")
    Call<Appointment> addDB(@Body Appointment appointment);
}
