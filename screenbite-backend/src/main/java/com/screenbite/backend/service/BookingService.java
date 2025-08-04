package com.screenbite.backend.service;

import com.screenbite.backend.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    List<Booking> getAllBookingsByUser(int id);
    Booking createBooking(Booking booking);

}
