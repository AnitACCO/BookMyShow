package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.reposistory.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheaterServicesImp implements TheaterServices{

    @Autowired
    private TheaterRepository theaterRepository;


    @Override
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public Theater updateTheater(Theater theater) {
        Optional<Theater> theaterObj = this.theaterRepository.findById(theater.getTheaterId());
        if(theaterObj.isPresent()){
            Theater theaterUpdate = theaterObj.get();
            theaterUpdate.setTheaterId(theater.getTheaterId());
            theaterUpdate.setTheaterName(theater.getTheaterName());
            theaterUpdate.setTheatercity(theater.getTheatercity());
            return this.theaterRepository.save(theaterUpdate);
        }else {
            throw new RuntimeException("No Theater found with + " + theater.getTheaterId());
        }
    }

    @Override
    public List<Theater> getAllTheater() {
        return this.theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterbyId(long theaterid) {
        Optional<Theater> theaterObj = this.theaterRepository.findById(theaterid);
        if(theaterObj.isPresent()){
            return theaterObj.get();
        }
        else {
            throw new RuntimeException("No theater found with id " + theaterid);
        }
    }

    @Override
    public void deleteTheater(long theaterid) {
        Optional<Theater> theaterObj = this.theaterRepository.findById(theaterid);
        if(theaterObj.isPresent()){
            theaterRepository.delete(getTheaterbyId(theaterid));
        }
        else {
            throw new RuntimeException("No Product found with id " + theaterid);
        }
    }
}
