package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface TheaterServices {
        Theater createTheater(Theater theater);
        Theater updateTheater(Theater theater);
        List<Theater> getAllTheater();
        Theater getTheaterbyId(long theaterid);
        void deleteTheater(long Theaterid);
}
