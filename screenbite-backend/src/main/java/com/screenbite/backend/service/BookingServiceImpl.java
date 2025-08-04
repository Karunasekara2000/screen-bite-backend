package com.screenbite.backend.service;

import com.screenbite.backend.model.Booking;
import com.screenbite.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements  BookingService{

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public List<Booking> getAllBookingsByUser(int id) {
        return bookingRepository.getAllBookingsByUser(id);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.createBooking(booking);
    }
}
