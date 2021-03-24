package ru.milov.taxi.service;

import ru.milov.taxi.dto.TaxiDto;
import ru.milov.taxi.entity.Client;
import ru.milov.taxi.entity.LocationClient;
import ru.milov.taxi.entity.Taxi;

import java.util.List;
import java.util.Map;

public interface ClientWorker {

    Map<Double, TaxiDto>  placeOrder(Client client);

    Taxi getTaxi(Long id, Client client);

    List<Taxi> showAllTaxi();

    Map<Double,TaxiDto> showNearest(LocationClient locationClient);

    List<Taxi> showOnlyFreeTaxi();

    Taxi closeRide(Long id, Client client);
}
