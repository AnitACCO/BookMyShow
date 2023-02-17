package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
