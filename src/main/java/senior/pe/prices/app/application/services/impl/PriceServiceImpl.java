package senior.pe.prices.app.application.services.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import senior.pe.prices.app.application.mappers.PriceMapper;
import senior.pe.prices.app.application.services.PriceService;
import senior.pe.prices.app.domain.dtos.PriceDto;
import senior.pe.prices.app.domain.entities.Price;
import senior.pe.prices.app.domain.repositories.PriceRepository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    @NonNull
    private PriceRepository priceRepository;

    @NonNull
    private PriceMapper priceMapper;

    @Override
    public List<PriceDto> findByParams(Long productId, Long brandId, Date date) {
        List<Price> entities = priceRepository.finByParams(productId, brandId, date);

        return priceMapper.priceListToPriceDtoList(entities);
    }

    @Override
    public List<PriceDto> findByParams1(Long productId, Long brandId, Date dateTime) {
        List<Price> entities = priceRepository.findPriceByStartDateAndProductIdAndBrandId(dateTime, productId, brandId);

        return priceMapper.priceListToPriceDtoList(entities);
    }
}
