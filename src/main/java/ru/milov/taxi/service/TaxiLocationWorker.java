package ru.milov.taxi.service;

import ru.milov.taxi.entity.LocationTaxi;
import ru.milov.taxi.entity.Taxi;

public interface TaxiLocationWorker {

    LocationTaxi setTaxiLocation(Taxi taxi);

}
