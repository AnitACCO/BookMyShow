package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Seat;
import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.services.ScreenServices;
import com.bookmyshow.BMS.services.SeatServices;
import com.bookmyshow.BMS.services.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatServices seatService;

    @Autowired
    private ScreenServices screenService;


    @GetMapping("/seat/{seatid}")
    private Seat getseatById(@PathVariable long seatid){
        return this.seatService.getSeatbyId(seatid);
    }

    @GetMapping("/seat")
    private ResponseEntity<List<Seat>> getAllSSeat(){
        return ResponseEntity.ok().body(this.seatService.getAllSeat());
    }

    @PostMapping("/addSeat/{screenid}")
    private void saveSeat(@RequestBody Seat seat, @PathVariable long screenid){
        Screen screen = this.screenService.getScreenbyId(screenid);
        screen.getSeats().add(seat);
        screenService.updateScreen(screen);
        //return ResponseEntity.ok().body(screen);
    }

    @PutMapping("/updateSeat/{seatid}")
    private ResponseEntity<Seat> updateSeat(@RequestBody Seat seat, @PathVariable long seatid){
        seat.setSeatId(seatid);
        return ResponseEntity.ok().body(this.seatService.updateSeat(seat));
    }

    @DeleteMapping("/deleteSeat/{seatid}")
    private HttpStatus deleteSeat(@PathVariable long seatid){
        this.seatService.deleteSeat(seatid);
        return HttpStatus.OK;

    }

}
