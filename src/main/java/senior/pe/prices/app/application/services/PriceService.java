package senior.pe.prices.app.application.services;

import java.util.Date;
import java.util.List;

import senior.pe.prices.app.domain.dtos.PriceDto;

public interface PriceService {
    List<PriceDto> findByParams(Long productId, Long brandId, Date date);
    List<PriceDto> findByParams1(Long productId, Long brandId, Date dateTime);
}
