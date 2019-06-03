package com.med.schedule.controller;

import com.med.schedule.dto.BookingDto;
import com.med.schedule.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository repository;

    public void addBooking(BookingDto dto){
        dto.setBookingRef(generateReference());
        repository.save(dto.toBooking());
    }

    public void updateBooking(BookingDto dto){
        repository.findByBookingRef(dto.getBookingRef())
                .map(b -> repository.save(dto.toBooking()))
                .orElseThrow(() -> new NoSuchElementException("booking not found"));
    }

    public List<BookingDto> findPatientBookings(String email){
        List<BookingDto> bookingDtos = new ArrayList<>();
        repository.findByPatientEmail(email).forEach(booking -> {
            bookingDtos.add(new BookingDto(booking));
        });
        return bookingDtos;
    }

    public List<BookingDto> findDoctorBookings(String email){
        List<BookingDto> bookingDtos = new ArrayList<>();
        repository.findByDoctorEmail(email).forEach(booking -> {
            bookingDtos.add(new BookingDto(booking));
        });
        return bookingDtos;
    }

    private String generateReference() {
        int num = 1_000_000 + new Random().nextInt(999_999);
        String ref = "REF" + num;
        if (isUsed(ref)) {
            return generateReference();
        }
        return ref;
    }

    private boolean isUsed(String reference) {
            return repository.findByBookingRef(reference).isPresent();
    }
}
