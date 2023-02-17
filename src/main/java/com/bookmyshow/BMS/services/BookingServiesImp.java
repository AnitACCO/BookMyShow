package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Booking;
import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.reposistory.BookingReposistory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BookingServiesImp implements BookingServices{

    @Autowired
    private BookingReposistory bookingReposistory;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingReposistory.save(booking);
    }

    @Override
    public Booking getBookingbyId(long bookingid) {
        Optional<Booking> bookObj = this.bookingReposistory.findById(bookingid);
        if(bookObj.isPresent()){
            return bookObj.get();
        }
        else {
            throw new RuntimeException("No booking found with id " + bookingid);
        }
    }

    @Override
    public void cancelBooking(long bookingid) {
        Optional<Booking> bookObj = this.bookingReposistory.findById(bookingid);
        if(bookObj.isPresent()){
            bookingReposistory.delete(getBookingbyId(bookingid));
        }
        else {
            throw new RuntimeException("No Booking found with id " + bookingid);
        }
    }
}
