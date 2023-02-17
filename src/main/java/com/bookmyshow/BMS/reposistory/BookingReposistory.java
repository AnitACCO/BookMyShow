package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingReposistory extends JpaRepository<Booking, Long> {
}
