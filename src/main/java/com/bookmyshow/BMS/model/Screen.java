package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "Screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screenid;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "screenid", referencedColumnName = "screenid")
    List<Seat> seats = new ArrayList<>() ;
}
