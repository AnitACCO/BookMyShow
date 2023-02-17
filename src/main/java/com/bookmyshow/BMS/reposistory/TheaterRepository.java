package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository  extends JpaRepository<Theater, Long> {
}
