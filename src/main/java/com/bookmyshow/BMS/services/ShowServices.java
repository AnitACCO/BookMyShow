package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Show;

import java.util.List;

public interface ShowServices {
    Show createShow(Show show);
    Show updateShow(Show show);
    List<Show> getAllShow();
    Show getShowbyId(long showid);
    void deleteShow(long showid);
}
