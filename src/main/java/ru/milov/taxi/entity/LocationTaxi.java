package ru.milov.taxi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location_taxi")
public class LocationTaxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    Taxi taxi;

    @Column(name = "x")
    int x;

    @Column(name = "y")
    int y;
}
