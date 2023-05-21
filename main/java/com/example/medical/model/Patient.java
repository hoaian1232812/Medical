package com.example.medical.model;



import java.sql.Date;
import java.util.List;

public class Patient {

    private String id;
    private String phone;
    private String name;

    private Date birth;
    private int gender;
    private String address;

    private List<Appointment> appointments;
    public Patient() {
    }

    public Patient(String id, String phone, String name, Date birth, int gender, String address) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
