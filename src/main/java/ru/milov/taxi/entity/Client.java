package ru.milov.taxi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "client")
@Accessors(chain = true)
public class Client {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @OneToOne
    Taxi taxi;

    @OneToOne
    LocationClient locationClient;

    @OneToOne
    LocationFinish locationFinish;

    @Column(name = "name")
    String name;

    @Column(name = "street")
    String street;

    @JsonIgnore
    @Column(name = "imove")
    boolean move;

}
