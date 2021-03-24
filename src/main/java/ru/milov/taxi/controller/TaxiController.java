package ru.milov.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.milov.taxi.entity.Taxi;
import ru.milov.taxi.service.TaxiWorker;

@RestController("/taxi")
@RequiredArgsConstructor
public class TaxiController {

    private final TaxiWorker taxiWorker;

    @PostMapping("/add")
    public Taxi addTaxi(@RequestBody Taxi taxi){
       return taxiWorker.add(taxi);
    }

    @PutMapping("/changeAvailabilityBusy/{id}")
    public Boolean changeAvailabilityBusy (@PathVariable Long id){
        return taxiWorker.changeAvailabilityBusy(id);
    }

    @PutMapping("/changeAvailabilityFree/{id}")
    public Boolean changeAvailabilityFree (@PathVariable Long id){
        return taxiWorker.changeAvailabilityFree(id);
    }

}
