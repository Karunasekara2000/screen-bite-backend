package com.screenbite.backend.controller;

import com.screenbite.backend.model.Booking;
import com.screenbite.backend.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){

        return ResponseEntity.ok(bookingService.getAllBookings());

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Booking>> getAllBookingsOfUser(@PathVariable int id){

        return ResponseEntity.ok(bookingService.getAllBookingsByUser(id));

    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.createBooking(booking));

    }
}
