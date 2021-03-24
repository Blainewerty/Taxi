package ru.milov.taxi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location_finish")
public class LocationFinish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @OneToOne
    Client client;

    @Column(name = "x")
    int x;

    @Column(name = "y")
    int y;

}
