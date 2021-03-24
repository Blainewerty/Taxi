package ru.milov.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.milov.taxi.entity.LocationTaxi;

public interface LocationTaxiRepository extends JpaRepository<LocationTaxi,Long> {
}
