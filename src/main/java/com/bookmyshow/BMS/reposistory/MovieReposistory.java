package com.bookmyshow.BMS.reposistory;

import com.bookmyshow.BMS.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReposistory extends JpaRepository<Movie, Long > {
}
