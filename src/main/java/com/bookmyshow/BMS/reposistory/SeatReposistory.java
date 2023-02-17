package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReposistory extends JpaRepository<Seat, Long> {
}
