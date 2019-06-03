package com.med.schedule.dto;

import com.med.schedule.model.Booking;

public class BookingDto {
    private long id;
    private String bookingRef;
    private PatientDto patientDto;
    private DoctorDto doctorDto;
    private String day;
    private String time;
    private String status;

    public BookingDto(PatientDto patientDto, DoctorDto doctorDto, String day, String time, String status) {
        this.patientDto = patientDto;
        this.doctorDto = doctorDto;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public BookingDto(Booking booking){
        setId(booking.getId());
        setBookingRef(booking.getBookingRef());
        setPatientDto(new PatientDto(booking.getPatient()));
        setDoctorDto(new DoctorDto(booking.getDoctor()));
        setDay(booking.getDay());
        setTime(booking.getTime());
        setStatus(booking.getStatus());
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

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public void setDoctorDto(DoctorDto doctorDto) {
        this.doctorDto = doctorDto;
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

    public Booking toBooking(){
        Booking booking = new Booking(bookingRef, patientDto.toPatient(), doctorDto.toDoctor(), day, time, status);
        booking.setId(id);
        return booking;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", bookingRef='" + bookingRef + '\'' +
                ", patientDto=" + patientDto +
                ", doctorDto=" + doctorDto +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
