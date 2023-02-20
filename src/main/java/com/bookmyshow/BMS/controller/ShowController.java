package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Show;
import com.bookmyshow.BMS.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowServices showService;

    @Autowired
    private MovieServices movieService;

    @Autowired
    private ScreenServices screenServices;

    @GetMapping("/show/{showid}")
    private Show getShowById(@PathVariable long showid){
        return showService.getShowbyId(showid);
    }

    @GetMapping("/show")
    private ResponseEntity<List<Show>> getAllShow(){
        return ResponseEntity.ok().body(this.showService.getAllShow());
    }

    @PostMapping("/addShow/{screenid}/{movieid}")
    private ResponseEntity<Show> saveShow(@RequestBody Show show, @PathVariable long screenid
                        ,@PathVariable long movieid ){
        show.setMovie(movieService.getMoviebyId(movieid));
        show.setScreen(screenServices.getScreenbyId(screenid));
        return ResponseEntity.ok().body(this.showService.createShow(show));
    }

    @DeleteMapping("/deleteShow/{showid}")
    private HttpStatus deleteShow(@PathVariable long showid){
        this.showService.deleteShow(showid);
        return HttpStatus.OK;

    }

}
