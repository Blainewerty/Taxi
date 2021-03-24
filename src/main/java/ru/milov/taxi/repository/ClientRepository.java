package ru.milov.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.milov.taxi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
