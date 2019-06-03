package com.med.schedule.repository;

import com.med.schedule.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    Optional<Booking> findByBookingRef(String ref);

    List<Booking> findByDoctorEmail(String email);

    List<Booking> findByPatientEmail(String email);
}
