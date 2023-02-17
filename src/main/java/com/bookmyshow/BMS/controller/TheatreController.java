package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.model.User;
import com.bookmyshow.BMS.services.TheaterServices;
import com.bookmyshow.BMS.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheatreController {
    @Autowired
    private TheaterServices theatreService;

    @GetMapping("/theatre/{theaterid}")
    private Theater getTheaterById(@PathVariable long theaterid){
        return this.theatreService.getTheaterbyId(theaterid);
    }

    @GetMapping("/theatre")
    private ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok().body(this.theatreService.getAllTheater());
    }

    @PostMapping("/addTheater")
    private ResponseEntity<Theater> saveTheatre(@RequestBody Theater theater){
        return ResponseEntity.ok().body(this.theatreService.createTheater(theater));
    }

    @PutMapping("/updateTheatre/{theaterid}")
    private ResponseEntity<Theater> updateTheater(@PathVariable long theaterid, @RequestBody Theater theater){
        theater.setTheaterId(theaterid);
        return ResponseEntity.ok().body(this.theatreService.updateTheater(theater));
    }

    @DeleteMapping("/deleteTheatre/{theaterid}")
    private HttpStatus deleteTheater(@PathVariable long theaterid) {
        this.theatreService.deleteTheater(theaterid);
        return HttpStatus.OK;
    }

}
