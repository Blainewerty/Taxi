package ru.milov.taxi.mapper;

import org.mapstruct.Mapper;
import ru.milov.taxi.dto.TaxiDto;
import ru.milov.taxi.entity.Taxi;

@Mapper(componentModel = "spring")
public interface TaxiMapper {

    TaxiDto toDto(Taxi taxi);

}


