package com.example.medical.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeSlot {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("start_work")
    @Expose
    private String startWork;
    @SerializedName("end_work")
    @Expose
    private String endWork;
    @SerializedName("work_shift")
    @Expose
    private Object workShift;
    @SerializedName("available_slot")
    @Expose
    private Integer availableSlot;
    @SerializedName("appointments")
    @Expose
    private List<Appointment> appointments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartWork() {
        return startWork;
    }

    public void setStartWork(String startWork) {
        this.startWork = startWork;
    }

    public String getEndWork() {
        return endWork;
    }

    public void setEndWork(String endWork) {
        this.endWork = endWork;
    }

    public Object getWorkShift() {
        return workShift;
    }

    public void setWorkShift(Object workShift) {
        this.workShift = workShift;
    }

    public Integer getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(Integer availableSlot) {
        this.availableSlot = availableSlot;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
