package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Booking;
import com.bookmyshow.BMS.model.Show;
import com.bookmyshow.BMS.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookingController {

    @Autowired
    private BookingServices bookingServices;

    @Autowired
    private ShowServices showServices;

    @Autowired
    private MovieServices movieServices;

    @Autowired
    private UserServices userServices;

    @Autowired
    private SeatServices seatServices;

    @GetMapping("/booking/{bookingid}")
    private Booking getBookingById(@PathVariable long bookingid){
        return bookingServices.getBookingbyId(bookingid);
    }


    @PostMapping("/addBooking/{bookingid}/{movieid}/{userid}/{seatid}/{showid}}")
    private ResponseEntity<Booking> saveShow(@RequestBody Booking booking, @PathVariable long bookingid,
                                             @PathVariable long movieid,@PathVariable long userid,
                                             @PathVariable long seatid, @PathVariable long showid){

            booking.setMovie(movieServices.getMoviebyId(movieid));
            booking.setUser(userServices.getUserbyId(userid));
            booking.setSeat(seatServices.getSeatbyId(seatid));
            booking.setShow(showServices.getShowbyId(showid));
            return ResponseEntity.ok().body(this.bookingServices.createBooking(booking));
        }

    @DeleteMapping("/deleteBooking/{bookingid}")
    private HttpStatus deleteShow(@PathVariable long bookingid){
        this.bookingServices.cancelBooking(bookingid);
        return HttpStatus.OK;

    }


}
