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
    @JoinColumn(name = "screenid", referencedColumnName = "screenid")
    private Screen screen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movieid", referencedColumnName = "movieid")
    private Movie movie;

}
