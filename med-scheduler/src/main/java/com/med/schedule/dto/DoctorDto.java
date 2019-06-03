package com.med.schedule.dto;

import com.med.schedule.model.Doctor;

public class DoctorDto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String category;
    private String gender;
    private long phone;
    private String password;

    public DoctorDto(String firstname, String lastname, String email, String category, String gender, long phone, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.category = category;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
    }

    public DoctorDto(Doctor doctor){
        setId(doctor.getId());
        setFirstname(doctor.getFirstname());
        setLastname(doctor.getLastname());
        setEmail(doctor.getEmail());
        setCategory(doctor.getCategory());
        setGender(doctor.getGender());
        setPhone(doctor.getPhone());
        setPassword(doctor.getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Doctor toDoctor(){
        Doctor doctor = new Doctor(firstname, lastname, email, category, gender,
                phone, password);
        doctor.setId(id);
        return doctor;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
