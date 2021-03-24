package ru.milov.taxi.service;

import ru.milov.taxi.entity.Client;
import ru.milov.taxi.entity.LocationClient;
import ru.milov.taxi.entity.LocationFinish;

public interface ClientLocationWorker {

    LocationClient setClientLocation(Client client);

    LocationFinish setFinishLocation(Client client);
}
