package com.med.schedule.endpoint;

import com.med.schedule.controller.BookingController;
import com.med.schedule.controller.DoctorController;
import com.med.schedule.controller.PatientController;
import com.med.schedule.dto.BookingDto;
import com.med.schedule.dto.DoctorDto;
import com.med.schedule.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/med")
public class RestEndpoint {
    @Autowired
    private BookingController bookingController;
    @Autowired
    private DoctorController doctorController;
    @Autowired
    private PatientController patientController;

    @PostMapping(path = "/booking")
    public ResponseEntity addBooking(@RequestBody BookingDto dto){
        bookingController.addBooking(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/booking")
    public ResponseEntity updateBooking(@RequestBody BookingDto dto){
        bookingController.updateBooking(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/doctor")
    public ResponseEntity createDoctor(@RequestBody DoctorDto dto){
        doctorController.registerDoctor(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/doctor")
    public ResponseEntity updateDoctor(@RequestBody DoctorDto dto){
        doctorController.updateDoctor(dto);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(path = "/doctor/{category}/find", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DoctorDto>> getDoctorByCategory(@PathVariable String category){
        return new ResponseEntity<>(doctorController.findDoctorCategory(category), HttpStatus.OK);
    }

    @GetMapping(path = "/doctor/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable String email){
        return new ResponseEntity<>(doctorController.findDoctor(email), HttpStatus.OK);
    }

    @GetMapping(path = "/doctor/booking/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BookingDto>> getBookingForDoctor(@PathVariable String email){
        return new ResponseEntity<>(bookingController.findDoctorBookings(email), HttpStatus.OK);
    }

    @PostMapping(path = "/patient")
    public ResponseEntity createPatient(@RequestBody PatientDto dto){
        patientController.registerPatient(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/patient")
    public ResponseEntity updatePatient(@RequestBody PatientDto dto){
        patientController.updatePatient(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/patient/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PatientDto> getPatient(@PathVariable String email){
        return new ResponseEntity<>(patientController.findPatient(email), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/booking/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BookingDto>> getBookingForPatient(@PathVariable String email){
        return new ResponseEntity<>(bookingController.findPatientBookings(email), HttpStatus.OK);
    }

}
