package ru.milov.taxi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milov.taxi.entity.LocationTaxi;
import ru.milov.taxi.entity.Taxi;
import ru.milov.taxi.service.TaxiLocationWorker;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaxiLocationWorkerImpl implements TaxiLocationWorker {

    private final Random random = new Random();

    @Override
    public LocationTaxi setTaxiLocation(Taxi taxi) {

        LocationTaxi locationTaxi = new LocationTaxi();

        locationTaxi.setX(random.nextInt(500));
        locationTaxi.setY(random.nextInt(500));

        return locationTaxi;
    }

}
