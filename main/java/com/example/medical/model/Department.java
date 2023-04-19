package com.example.medical.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Department implements Serializable {

    private String id;

    private String url;
    private String name;
    private String decription;

    private List<Doctor> doctors;

    public Department() {
    }

    public Department(String id, String url, String name, String decription) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.decription = decription;
        this.doctors = new ArrayList<>();
    }

    public Department(String id, String url, String name, String decription, List<Doctor> doctors) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.decription = decription;
        this.doctors = doctors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getDecription() {
        return decription;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(decription, that.decription) && Objects.equals(doctors, that.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, decription, doctors);
    }
}

