package ru.milov.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.milov.taxi.entity.Taxi;

import java.util.List;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    @Query(value = "update taxi set isBusy = true where id = ?", nativeQuery = true)
    boolean changeAvailabilityBusy(Long id);

    @Query(value = "update taxi set isBusy = false where id = ?", nativeQuery = true)
    boolean changeAvailabilityFree(Long id);

    List<Taxi> findByBusyFalse();
}

