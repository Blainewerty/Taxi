package ru.milov.taxi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milov.taxi.entity.Taxi;
import ru.milov.taxi.repository.TaxiRepository;
import ru.milov.taxi.service.TaxiLocationWorker;
import ru.milov.taxi.service.TaxiWorker;

@Service
@RequiredArgsConstructor
public class TaxiWorkerImpl implements TaxiWorker {

    private final TaxiRepository taxiRepository;

    private final TaxiLocationWorker taxiLocationWorker;

    @Override
    public Taxi add(Taxi taxi) {

        taxi.setLocationTaxi(taxiLocationWorker.setTaxiLocation(taxi));

       return taxiRepository.save(taxi);
    }

    @Override
    public void update(Taxi taxi) {
        taxiRepository.save(taxi);
    }

    @Override
    public void takeOrder(Taxi taxi) {

    }

    @Override
    public boolean changeAvailabilityBusy(Long id) {
        return taxiRepository.changeAvailabilityBusy(id);
    }

    @Override
    public boolean changeAvailabilityFree(Long id) {
        return taxiRepository.changeAvailabilityFree(id);
    }


}
