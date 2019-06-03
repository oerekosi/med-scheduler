package com.med.schedule.bootstrap;

import com.med.schedule.controller.BookingController;
import com.med.schedule.controller.DoctorController;
import com.med.schedule.controller.PatientController;
import com.med.schedule.dto.BookingDto;
import com.med.schedule.dto.DoctorDto;
import com.med.schedule.dto.PatientDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Boostrap {

    @Bean
    public CommandLineRunner runner(PatientController patientController,
                                    DoctorController doctorController,
                                    BookingController bookingController) {
        return (args) -> {
            getPatients().forEach(patient -> patientController.registerPatient(patient));
            getDoctors().forEach(doctor -> doctorController.registerDoctor(doctor));
            List<PatientDto> patientDtos = patientController.getAllPatients();
            List<DoctorDto> doctorDtos = doctorController.getAllDoctors();
            getBookings(patientDtos, doctorDtos).forEach(booking -> bookingController.addBooking(booking));
        };
    }

    private static List<PatientDto> getPatients(){
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientDtoList.add(new PatientDto("Tom", "Michelle", "tm@patient.com", "M", 8071112223L, "password"));
        patientDtoList.add(new PatientDto("Harry", "Tang", "ht@patient.com", "M", 8077583573L, "password"));
        patientDtoList.add(new PatientDto("Emma", "Stone", "es@patient.com", "F", 8077594038L, "password"));
        patientDtoList.add(new PatientDto("Han", "Shaw", "hs@patient.com", "M", 8072537789L, "password"));
        patientDtoList.add(new PatientDto("Sam", "Tully", "st@patient.com", "F", 8071117654L, "password"));
        return patientDtoList;
    }

    private static List<DoctorDto> getDoctors(){
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        doctorDtoList.add(new DoctorDto("Tom", "Michelle", "tm@doctor.com", "Physician", "M", 8071112223L, "password"));
        doctorDtoList.add(new DoctorDto("Harry", "Tang", "ht@doctor.com", "Pharmacist", "M", 8077583573L, "password"));
        doctorDtoList.add(new DoctorDto("Emma", "Stone", "es@doctor.com", "Clinician", "F", 8077594038L, "password"));
        doctorDtoList.add(new DoctorDto("Han", "Shaw", "hs@doctor.com", "Dentist", "M",  8072537789L, "password"));
        doctorDtoList.add(new DoctorDto("Sam", "Tully", "st@doctor.com", "Physician", "F", 8071117654L, "password"));
        return doctorDtoList;
    }

    private static List<BookingDto> getBookings(List<PatientDto> patients, List<DoctorDto> doctors){
        List<BookingDto> bookingList = new ArrayList<>();
        bookingList.add(new BookingDto(patients.get(0), doctors.get(2), "Monday", "10.00AM", "accepted"));
        bookingList.add(new BookingDto(patients.get(1), doctors.get(4), "Tuesday", "11.00AM", "accepted"));
        bookingList.add(new BookingDto(patients.get(2), doctors.get(3), "Wednessday", "12.00PM", "accepted"));
        bookingList.add(new BookingDto(patients.get(3), doctors.get(2), "Monday", "1.00PM", "accepted"));
        bookingList.add(new BookingDto(patients.get(0), doctors.get(1), "Friday", "2.00PM", "accepted"));
        bookingList.add(new BookingDto(patients.get(4), doctors.get(0), "Thursday", "3.00PM", "accepted"));
        return bookingList;
    }
}
