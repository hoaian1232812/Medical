package com.example.medical.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Appointment {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("patient")
    @Expose
    private Patient patient;
    @SerializedName("doctor")
    @Expose
    private Doctor doctor;
    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    @SerializedName("timeSlot")
    @Expose
    private TimeSlot timeSlot;

    public Appointment() {
    }

    public Appointment(int status, String description, Patient patient, Doctor doctor, Schedule schedule, TimeSlot timeSlot) {
        this.status = status;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
        this.schedule = schedule;
        this.timeSlot = timeSlot;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", schedule=" + schedule +
                ", timeSlot=" + timeSlot +
                '}';
    }
}
