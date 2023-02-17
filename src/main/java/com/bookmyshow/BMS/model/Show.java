package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "show")
public class Show{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long showId;

    private String showtime;

    /*
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Booking book;
    */

    
}
