package com.med.schedule.model;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column(unique = true)
    private String bookingRef;
    @OneToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne(targetEntity = Doctor.class)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private String day;
    private String time;
    private String status;

    protected Booking() {}

    public Booking(String bookingRef, Patient patient, Doctor doctor, String day, String time, String status) {
        this.bookingRef = bookingRef;
        this.patient = patient;
        this.doctor = doctor;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
