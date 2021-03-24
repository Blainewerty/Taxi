package ru.milov.taxi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milov.taxi.entity.Client;
import ru.milov.taxi.entity.LocationClient;
import ru.milov.taxi.entity.LocationFinish;
import ru.milov.taxi.service.ClientLocationWorker;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ClientLocationWorkerImpl implements ClientLocationWorker {

    private final Random random = new Random();

    @Override
    public LocationClient setClientLocation(Client client) {

        LocationClient locationClient = new LocationClient();

        locationClient.setClient(client);
        locationClient.setX(random.nextInt(500));
        locationClient.setY(random.nextInt(500));

        return locationClient;
    }

    @Override
    public LocationFinish setFinishLocation(Client client) {

        LocationFinish locationFinish = new LocationFinish();

        locationFinish.setClient(client);
        locationFinish.setX(random.nextInt(500));
        locationFinish.setY(random.nextInt(500));

        return locationFinish;
    }

}
