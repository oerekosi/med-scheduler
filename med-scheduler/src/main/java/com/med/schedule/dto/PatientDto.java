package com.med.schedule.dto;

import com.med.schedule.model.Patient;

public class PatientDto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private long phone;
    private String password;

    public PatientDto(String firstname, String lastname, String email, String gender, long phone, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
    }

    public PatientDto(Patient patient){
        setId(patient.getId());
        setFirstname(patient.getFirstname());
        setLastname(patient.getLastname());
        setEmail(patient.getEmail());
        setGender(patient.getGender());
        setPhone(patient.getPhone());
        setPassword(patient.getPassword());
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

    public Patient toPatient(){
        Patient patient = new Patient(firstname, lastname, email, gender,
                phone, password);
        patient.setId(id);
        return patient;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
