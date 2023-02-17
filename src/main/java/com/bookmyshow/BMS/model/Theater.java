package com.bookmyshow.BMS.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter


@Entity
@Table(name = "Theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long theaterId;

    @Column(name = "theatername")
    private String theaterName;

    @Column(name = "city")
    private String theatercity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "theaterid", referencedColumnName = "theaterid")
    List<Screen> screens = new ArrayList<>() ;
}
