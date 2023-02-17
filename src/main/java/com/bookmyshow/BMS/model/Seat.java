package com.bookmyshow.BMS.model;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

import javax.annotation.Generated;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seatId;

    @Column(name = "seatname")
    private String seatName;

    @Column(name = "seattype")
    private String seatType;

    @Column(name = "price")
    private int price;
}

