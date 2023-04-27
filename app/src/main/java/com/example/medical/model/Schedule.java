package com.example.medical.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Schedule {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("work_date")
    @Expose
    private String workDate;
    @SerializedName("timeSlots")
    @Expose
    private List<TimeSlot> timeSlots;
    @SerializedName("appointments")
    @Expose
    private List<Appointment> appointments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

}
