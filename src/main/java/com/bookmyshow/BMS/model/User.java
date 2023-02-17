package com.bookmyshow.BMS.model;


import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String  email;

    @Column(name = "phoneno")
    private long phoneno;
}
