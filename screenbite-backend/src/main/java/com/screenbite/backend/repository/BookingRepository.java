package com.screenbite.backend.repository;

import com.screenbite.backend.model.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> getAllBookings();
    List<Booking> getAllBookingsByUser(int id);
    Booking createBooking(Booking booking);
    Booking editBooking(Booking booking);
    Booking deleteBooking(int bookingId);


}
