package ru.milov.taxi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "taxi")
@Accessors(chain = true)
public class Taxi {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    Client client;

    @Column(name = "car")
    String car;

    @Column(name = "driver_name")
    String driverName;

    @OneToOne(cascade = CascadeType.ALL)
    LocationTaxi locationTaxi;

    @Column(name = "busy")
    boolean busy;
}
