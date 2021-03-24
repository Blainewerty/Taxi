package ru.milov.taxi.service;

import ru.milov.taxi.entity.Taxi;

public interface TaxiWorker {

    Taxi add(Taxi taxi);

    void update(Taxi taxi);

    void takeOrder(Taxi taxi);

    boolean changeAvailabilityBusy(Long id);

    boolean changeAvailabilityFree(Long id);

}
