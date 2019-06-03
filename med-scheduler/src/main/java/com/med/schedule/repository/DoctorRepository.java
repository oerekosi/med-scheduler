package com.med.schedule.repository;

import com.med.schedule.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);

    List<Doctor> findByCategory(String category);
}
