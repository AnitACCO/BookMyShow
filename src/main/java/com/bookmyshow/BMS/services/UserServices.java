package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface UserServices {
    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUser();
    User getUserbyId(long userid);
    void deleteUser(long userid);
}
