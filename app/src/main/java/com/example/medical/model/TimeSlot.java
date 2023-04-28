package com.example.medical.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeSlot implements Serializable {
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
    private String workShift;
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

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
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

    public String getTime() {
        String start = this.startWork;
        String end = this.endWork;
        if (this.workShift != null)
            return this.workShift + start.substring(0, start.lastIndexOf(":")) + " - " + end.substring(0, end.lastIndexOf(":"));
        return start.substring(0, start.lastIndexOf(":")) + " - " + end.substring(0, end.lastIndexOf(":"));
    }
}
