package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Booking;
import com.bookmyshow.BMS.model.Movie;

import java.util.List;

public interface BookingServices {
    Booking createBooking(Booking booking);
    Booking getBookingbyId(long bookingid);
    void cancelBooking(long bookingid);
}
