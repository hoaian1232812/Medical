package com.example.medical.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Doctor {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url_photo")
    @Expose
    private String urlPhoto;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("education")
    @Expose
    private String education;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("schedules")
    @Expose
    private List<Schedule> schedules;
    @SerializedName("appointments")
    @Expose
    private List<Appointment> appointments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", fee=" + fee +
                ", rating=" + rating +
                ", education='" + education + '\'' +
                ", description='" + description + '\'' +
                ", schedules=" + schedules +
                ", appointments=" + appointments +
                '}';
    }
}

