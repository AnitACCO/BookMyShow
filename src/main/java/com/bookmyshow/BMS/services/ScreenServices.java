package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Screen;
import com.bookmyshow.BMS.model.Theater;

import java.util.List;

public interface ScreenServices {
    Screen createScreen(Screen screen);
    Screen updateScreen(Screen screen);
    List<Screen> getAllScreen();
    Screen getScreenbyId(long screenid);
    void deleteScreen(long screenid);
}
