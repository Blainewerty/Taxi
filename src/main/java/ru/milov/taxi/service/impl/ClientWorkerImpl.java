package ru.milov.taxi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.milov.taxi.dto.TaxiDto;
import ru.milov.taxi.entity.Client;
import ru.milov.taxi.entity.LocationClient;
import ru.milov.taxi.entity.LocationTaxi;
import ru.milov.taxi.entity.Taxi;
import ru.milov.taxi.mapper.TaxiMapper;
import ru.milov.taxi.repository.TaxiRepository;
import ru.milov.taxi.service.ClientLocationWorker;
import ru.milov.taxi.service.ClientWorker;
import ru.milov.taxi.service.TaxiWorker;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientWorkerImpl implements ClientWorker {

    private final TaxiMapper taxiMapper;

    private final TaxiRepository taxiRepository;

    private final TaxiWorker taxiWorker;

    private final ClientLocationWorker clientLocationWorker;

    @Override
    public Map<Double, TaxiDto>  placeOrder(Client client) {

        client.setLocationClient(clientLocationWorker.setClientLocation(client));

        client.setLocationFinish(clientLocationWorker.setFinishLocation(client));

        return showNearest(client.getLocationClient());
    }

    @Override
    public Map<Double, TaxiDto> showNearest(LocationClient locationClient) {
        return showOnlyFreeTaxi().stream()
                .collect(Collectors.toMap(i -> checkDistance(locationClient, i.getLocationTaxi()), taxiMapper::toDto))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    @Override
    @SneakyThrows
    public Taxi getTaxi(Long id, Client client) {
        taxiWorker.changeAvailabilityBusy(id);
        Taxi taxi = taxiRepository.findById(id).orElseThrow(Exception::new);
        taxi.setClient(client);
        return taxi;
    }

    @Override
    @SneakyThrows
    public Taxi closeRide(Long id, Client client) {
        taxiWorker.changeAvailabilityFree(id);
        return taxiRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public List<Taxi> showOnlyFreeTaxi() {
        return taxiRepository.findByBusyFalse();
    }

    @Override
    public List<Taxi> showAllTaxi() {
        return taxiRepository.findAll();
    }

    private double checkDistance(LocationClient locationClient, LocationTaxi locationTaxi){
        return Math.sqrt(Math.pow(locationClient.getX()-locationTaxi.getX(),2)
                +
                (Math.pow(locationClient.getY()-locationTaxi.getY(),2)));
    }


}
