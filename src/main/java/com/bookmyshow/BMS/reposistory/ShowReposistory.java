package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowReposistory extends JpaRepository<Show, Long> {
}
