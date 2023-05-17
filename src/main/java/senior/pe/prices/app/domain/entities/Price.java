package senior.pe.prices.app.domain.entities;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "PRICES")
public class Price {
    @Id 
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND_ID", nullable = false)
    @Basic(optional = false)
    private Long brandId;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
 
    @Column(name = "PRICE_LIST", nullable = false)
    @Basic(optional = false)
    private Integer priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    @Basic(optional = false)
    private Long productId;

    @Column(name = "PRIORITY", nullable = false)
    @Basic(optional = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false)
    @Basic(optional = false)
    private BigDecimal price;

    @Column(name = "CURR", nullable = false)
    @Basic(optional = false)
    private String currency;
}
