package ru.milov.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.milov.taxi.dto.TaxiDto;
import ru.milov.taxi.entity.Client;
import ru.milov.taxi.entity.Taxi;
import ru.milov.taxi.service.ClientWorker;
import java.util.List;
import java.util.Map;

@RestController("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientWorker clientWorker;

    @GetMapping("/")
    public List<Taxi> getListTaxi(){
        return clientWorker.showAllTaxi();
    }

    @PostMapping("/order")
    public Map<Double, TaxiDto> order(@RequestBody Client client){
        return clientWorker.placeOrder(client);
    }

    @PostMapping("/drive/{id}")
    public Taxi drive(@PathVariable Long id, @RequestBody Client client){
        return clientWorker.getTaxi(id, client);
    }

    @PostMapping("/closeride/{id}")
    public Taxi closeRide(@PathVariable Long id, @RequestBody Client client){
        return clientWorker.closeRide(id,client);
    }

}
