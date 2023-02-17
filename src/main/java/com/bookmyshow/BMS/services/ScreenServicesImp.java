package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.reposistory.ScreenReposistory;
import com.bookmyshow.BMS.reposistory.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ScreenServicesImp implements ScreenServices{

    @Autowired
    private ScreenReposistory screenReposistory;

    @Override
    public Screen createScreen(Screen screen) {
        return screenReposistory.save(screen);
    }

    @Override
    public Screen updateScreen(Screen screen) {
        Optional<Screen> screenObj = this.screenReposistory.findById(screen.getScreenid());
        if(screenObj.isPresent()){
            Screen screenUpdate = screenObj.get();
            screenUpdate.setName(screen.getName());
            return this.screenReposistory.save(screenUpdate);
        }else {
            throw new RuntimeException("No Theater found with + " + screen.getScreenid());
        }
    }

    @Override
    public List<Screen> getAllScreen() {
        return this.screenReposistory.findAll();
    }

    @Override
    public Screen getScreenbyId(long screenid) {
        Optional<Screen> screenObj = this.screenReposistory.findById(screenid);
        if(screenObj.isPresent()){
            return screenObj.get();
        }
        else {
            throw new RuntimeException("No screen found with id " + screenid);
        }
    }

    @Override
    public void deleteScreen(long screenid) {
        Optional<Screen> screenObj = this.screenReposistory.findById(screenid);
        if(screenObj.isPresent()){
            screenReposistory.delete(getScreenbyId(screenid));
        }
        else {
            throw new RuntimeException("No Screen found with id " + screenid);
        }
    }
}
