package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Seat;
import com.bookmyshow.BMS.model.Show;
import com.bookmyshow.BMS.reposistory.ShowReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ShowServicesImp implements ShowServices{

    @Autowired
    private ShowReposistory showReposistory;

    @Override
    public Show createShow(Show show) {
        return this.showReposistory.save(show);
    }

    @Override
    public Show updateShow(Show show) {
        Optional<Show> showObj = this.showReposistory.findById(show.getShowId());
        if(showObj.isPresent()){
            Show showUpdate = showObj.get();
            showUpdate.setShowtime(show.getShowtime());
            showUpdate.setShowdate(show.getShowdate());
            showUpdate.setMovie(show.getMovie());
            showUpdate.setScreen(show.getScreen());
            return this.showReposistory.save(showUpdate);
        }else {
            throw new RuntimeException("Show not found");
        }
    }

    @Override
    public List<Show> getAllShow() {
        return this.showReposistory.findAll();
    }

    @Override
    public Show getShowbyId(long showid) {
        Optional<Show> showObj = this.showReposistory.findById(showid);
        if(showObj.isPresent()) {
            return showObj.get();
        }
        else{
            throw new RuntimeException("Show not found");
        }

    }

    @Override
    public void deleteShow(long showid) {
        this.showReposistory.deleteById(showid);
    }
}
