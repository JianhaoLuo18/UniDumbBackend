package com.flatly.repository;

import com.flatly.model.Booking;
import com.flatly.model.Booking.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status); // Existing method
    List<Booking> findByUserEmailAndStatus(String userEmail, BookingStatus status); // New method
}
