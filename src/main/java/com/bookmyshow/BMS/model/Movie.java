package com.bookmyshow.BMS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType .AUTO)
    private long movieid;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "movieGenre")
    private String movieGenre;

    @Column(name = "movieLanguage")
    private String movieLanguage;
}
