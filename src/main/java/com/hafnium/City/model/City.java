package com.hafnium.City.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "city_name", nullable = false)
    private String cityName;
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
}
