package ru.milov.taxi.dto;

import lombok.Data;
import ru.milov.taxi.entity.LocationTaxi;

@Data
public class TaxiDto {


    String car;

    String driverName;

    LocationTaxi locationTaxi;

    boolean busy;

}
