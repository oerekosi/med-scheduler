package com.med.schedule.controller;

import com.med.schedule.dto.PatientDto;
import com.med.schedule.model.Patient;
import com.med.schedule.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository repository;

    public PatientDto registerPatient(PatientDto dto) {
        Patient patient = repository.save(dto.toPatient());
        return new PatientDto(patient);
    }

    public PatientDto updatePatient(PatientDto dto) {
        return  repository.findByEmail(dto.getEmail()).map(p -> {
            Patient patient = repository.save(dto.toPatient());
            return new PatientDto(patient);
        }).orElseThrow(() -> new NoSuchElementException("patient not found"));
    }

    public PatientDto findPatient(String email) {
        return repository.findByEmail(email)
                .map(patient -> new PatientDto(patient))
                .orElseThrow(() -> new NoSuchElementException("patient not found"));
    }

    public List<PatientDto> getAllPatients(){
        List<PatientDto> patientDtos = new ArrayList<>();
        repository.findAll().forEach(patient -> patientDtos.add(new PatientDto(patient)));
        return patientDtos;
    }

}
