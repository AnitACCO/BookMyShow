package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name="Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    private Date createdTime;

    private int bookingprice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "showId", referencedColumnName = "showId")
    private Show show;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movieid", referencedColumnName = "movieid")
    private Movie movie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seatid", referencedColumnName = "seatid")
    private Seat seat;

}
