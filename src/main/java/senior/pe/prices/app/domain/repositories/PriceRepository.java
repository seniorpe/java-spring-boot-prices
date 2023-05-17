package senior.pe.prices.app.domain.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import senior.pe.prices.app.domain.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT entity from senior.pe.prices.app.domain.entities.Price entity WHERE :date BETWEEN entity.startDate AND entity.endDate AND entity.productId = :productId AND entity.brandId = :brandId")
    List<Price> finByParams(@Param("productId") Long productId, @Param("brandId") Long brandId,
            @Param("date") Date date);

    List<Price> findPriceByStartDateAndProductIdAndBrandId(Date dateTime, Long productId, Long brandId);
}
