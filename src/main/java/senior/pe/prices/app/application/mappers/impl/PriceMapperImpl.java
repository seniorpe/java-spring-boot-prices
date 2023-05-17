package senior.pe.prices.app.application.mappers.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import senior.pe.prices.app.application.mappers.PriceMapper;
import senior.pe.prices.app.domain.dtos.PriceDto;
import senior.pe.prices.app.domain.entities.Price;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceMapperImpl implements PriceMapper {

    @NonNull
    private ModelMapper mapper;

    @Override
    public List<PriceDto> priceListToPriceDtoList(List<Price> entities) {

        List<PriceDto> dtos = Arrays.asList(mapper.map(entities, PriceDto[].class));

        return dtos;
    }
}
