package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Seat;

import java.util.List;

public interface SeatServices {
    Seat createSeat(Seat seat);
    Seat updateSeat(Seat seat);
    List<Seat> getAllSeat();
    Seat getSeatbyId(long seatid);
    void deleteSeat(long seatid);
}
