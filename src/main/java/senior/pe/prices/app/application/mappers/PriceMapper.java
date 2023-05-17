package senior.pe.prices.app.application.mappers;

import java.util.List;

import senior.pe.prices.app.domain.dtos.PriceDto;
import senior.pe.prices.app.domain.entities.Price;

public interface PriceMapper {
    List<PriceDto> priceListToPriceDtoList(List<Price> entities);
}
