package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Seat;
import com.bookmyshow.BMS.reposistory.ScreenReposistory;
import com.bookmyshow.BMS.reposistory.SeatReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServicesImp implements SeatServices{
    @Autowired
    private SeatReposistory seatReposistory;

    @Override
    public Seat createSeat(Seat seat) {
        return seatReposistory.save(seat);
    }

    @Override
    public Seat updateSeat(Seat seat) {
        Optional<Seat> seatObj = this.seatReposistory.findById(seat.getSeatId());
        if(seatObj.isPresent()){
            Seat seatUpdate = seatObj.get();
            seatUpdate.setSeatName(seat.getSeatName());
            seatUpdate.setSeatType(seat.getSeatType());
            seatUpdate.setPrice(seat.getPrice());
            return this.seatReposistory.save(seatUpdate);
        }else {
            throw new RuntimeException("No Theater found with + " + seat.getSeatId());
        }
    }

    @Override
    public List<Seat> getAllSeat() {
        return this.seatReposistory.findAll();
    }

    @Override
    public Seat getSeatbyId(long seatid) {
        Optional<Seat> seatObj = this.seatReposistory.findById(seatid);
        if(seatObj.isPresent()){
            return seatObj.get();
        }
        else {
            throw new RuntimeException("No screen found with id " + seatid);
        }
    }

    @Override
    public void deleteSeat(long seatid) {
        Optional<Seat> seatObj = this.seatReposistory.findById(seatid);
        if(seatObj.isPresent()){
            seatReposistory.delete(getSeatbyId(seatid));
        }
        else {
            throw new RuntimeException("No Screen found with id " + seatid);
        }
    }
}
