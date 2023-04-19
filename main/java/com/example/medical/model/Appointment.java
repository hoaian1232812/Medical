package com.example.medical.model;


import java.io.Serializable;


public class Appointment implements Serializable {

    private int id;
    private int status;
    private String description;

    private Patient patient;

    private Doctor doctor;

    private Schedule schedule;

    private TimeSlot timeSlot;

    public Appointment() {
    }

    public Appointment(int id, int status, String description, Patient patient, Doctor doctor, Schedule schedule, TimeSlot timeSlot) {
        this.id = id;
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
}
