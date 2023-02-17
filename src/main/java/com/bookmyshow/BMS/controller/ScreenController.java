package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.services.ScreenServices;
import com.bookmyshow.BMS.services.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreenController {
    @Autowired
    private ScreenServices screenService;

    @Autowired
    private TheaterServices theaterService;


    @GetMapping("/screen/{screenid}")
    private Screen getscreenById(@PathVariable long screenid){
        return this.screenService.getScreenbyId(screenid);
    }

    @GetMapping("/screen")
    private ResponseEntity<List<Screen>> getAllScreen(){
        return ResponseEntity.ok().body(this.screenService.getAllScreen());
    }

    @PostMapping("/addScreen/{theaterid}")
    private void saveScreen(@RequestBody Screen screen, @PathVariable long theaterid){
        Theater theater = this.theaterService.getTheaterbyId(theaterid);
        theater.getScreens().add(screen);
        theaterService.updateTheater(theater);
        //return ResponseEntity.ok().body(screen);
    }

    @PutMapping("/updateScreen/{screenid}")
    private ResponseEntity<Screen> updateScreen(@RequestBody Screen screen, @PathVariable long screenid){
        screen.setScreenid(screenid);
        return ResponseEntity.ok().body(this.screenService.updateScreen(screen));
    }

    @DeleteMapping("/deleteScreen/{screenid}")
    private HttpStatus deleteScreen(@PathVariable long screenid){
        this.screenService.deleteScreen(screenid);
        return HttpStatus.OK;

    }

}
