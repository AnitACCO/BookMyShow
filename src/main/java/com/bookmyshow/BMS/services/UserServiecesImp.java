package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.User;
import com.bookmyshow.BMS.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiecesImp implements UserServices {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserid());
        if(userObj.isPresent()){
            User userUpdate = userObj.get();
            userUpdate.setUserid(user.getUserid());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPhoneno(user.getPhoneno());
            userUpdate.setEmail(user.getEmail());
            return this.userRepository.save(userUpdate);
        }else {
            throw new RuntimeException("No product found with + " + user.getUserid());
        }
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserbyId(long userid) {
        Optional<User> pcObj = this.userRepository.findById(userid);
        if(pcObj.isPresent()){
            return pcObj.get();
        }
        else {
            throw new RuntimeException("No User found with id " + userid);
        }
    }

    @Override
    public void deleteUser(long userid) {
        Optional<User> pcObj = this.userRepository.findById(userid);
        if(pcObj.isPresent()){
            userRepository.delete(getUserbyId(userid));
        }
        else {
            throw new RuntimeException("No Product found with id " + userid);
        }
    }
}
