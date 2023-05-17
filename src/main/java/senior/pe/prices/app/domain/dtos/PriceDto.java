package senior.pe.prices.app.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PriceDto implements Serializable {

    private Integer brandId; //2

    private Date startDate; //4

    private Date endDate; //5
 
    private Short priceList; //3

    private Integer productId; //1

    private BigDecimal price; //6
}
