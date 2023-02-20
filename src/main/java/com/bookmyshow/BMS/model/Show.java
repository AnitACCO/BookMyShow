package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "shows")
public class Show{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long showId;

    private String showtime;

    private Date showdate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "screenid", referencedColumnName = "screenid")
    private Screen screen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movieid", referencedColumnName = "movieid")
    private Movie movie;

    
}
