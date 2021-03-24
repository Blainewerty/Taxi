package ru.milov.taxi.mapper;

import org.mapstruct.Mapper;
import ru.milov.taxi.dto.ClientDto;
import ru.milov.taxi.entity.Client;

@Mapper
public interface ClientMapper {

    ClientDto toDto(Client client);

}
