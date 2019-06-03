package com.med.schedule.controller;

import com.med.schedule.dto.DoctorDto;
import com.med.schedule.model.Doctor;
import com.med.schedule.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    public DoctorDto registerDoctor(DoctorDto dto){
        Doctor doctor = repository.save(dto.toDoctor());
        return new DoctorDto(doctor);
    }

    public DoctorDto updateDoctor(DoctorDto dto){
        return repository.findByEmail(dto.getEmail())
                .map(d -> {
                    Doctor doctor = repository.save(dto.toDoctor());
                    return new DoctorDto(doctor);
                })
                .orElseThrow(() -> new NoSuchElementException("doctor not found"));
    }

    public DoctorDto findDoctor(String email){
        return repository.findByEmail(email)
                .map(doctor -> new DoctorDto(doctor))
                .orElseThrow(() -> new NoSuchElementException("doctor not found"));
    }

    public List<DoctorDto> findDoctorCategory(String category){
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        repository.findByCategory(category)
                .forEach(doctor -> doctorDtoList.add(new DoctorDto(doctor)));
        return doctorDtoList;
    }

    public List<DoctorDto> getAllDoctors(){
        List<DoctorDto> doctorDtos = new ArrayList<>();
        repository.findAll().forEach(doctor -> doctorDtos.add(new DoctorDto(doctor)));
        return doctorDtos;
    }
}
