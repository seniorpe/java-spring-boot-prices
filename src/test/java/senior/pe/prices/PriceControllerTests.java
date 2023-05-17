package senior.pe.prices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import senior.pe.prices.app.domain.entities.Price;
import senior.pe.prices.app.domain.repositories.PriceRepository;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Date;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PriceRepository priceRepository;

        @Test
        public void testRequestAt10AMOnDay14() throws Exception {
                Date dateTime = new Date(120, 5, 14, 10, 0); // 2020-06-14 10:00
                Long productId = 35455L;
                Long brandId = 1L;

                List<Price> prices = Arrays.asList(
                                createPrice(productId, brandId, new Date(120, 5, 14, 0, 0),
                                                new Date(120, 11, 31, 23, 59, 59), 1, 0, new BigDecimal(35.50), "EUR"));

                when(priceRepository.findPriceByStartDateAndProductIdAndBrandId(any(Date.class), eq(productId),
                                eq(brandId)))
                                .thenReturn(prices);

                mockMvc.perform(get("/prices/findByParams1")
                                .param("dateTime", String.valueOf(dateTime.getTime()))
                                .param("productId", String.valueOf(productId))
                                .param("brandId", String.valueOf(brandId)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(productId))
                                .andExpect(jsonPath("$.brandId").value(brandId));
        }

        @Test
        public void testRequestAt4PMOnDay14() throws Exception {
                Date dateTime = new Date(120, 5, 14, 16, 0); // 2020-06-14 16:00
                Long productId = 35455L;
                Long brandId = 1L;

                List<Price> prices = Arrays.asList(
                                createPrice(productId, brandId, new Date(120, 5, 14, 15, 0),
                                                new Date(120, 5, 14, 18, 30), 2, 1, new BigDecimal(25.45), "USD"));

                when(priceRepository.findPriceByStartDateAndProductIdAndBrandId(any(Date.class), eq(productId),
                                eq(brandId)))
                                .thenReturn(prices);

                mockMvc.perform(get("/prices/findByParams1")
                                .param("dateTime", String.valueOf(dateTime.getTime()))
                                .param("productId", String.valueOf(productId))
                                .param("brandId", String.valueOf(brandId)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(productId))
                                .andExpect(jsonPath("$.brandId").value(brandId));
        }

        @Test
        public void testRequestAt9PMOnDay14() throws Exception {
                Date dateTime = new Date(120, 5, 14, 21, 0); // 2020-06-14 21:00
                Long productId = 35455L;
                Long brandId = 1L;

                List<Price> prices = Arrays.asList(
                                createPrice(productId, brandId, new Date(120, 5, 14, 20, 0),
                                                new Date(120, 5, 14, 22, 0), 3, 2, new BigDecimal(30.0), "EUR"));

                when(priceRepository.findPriceByStartDateAndProductIdAndBrandId(any(Date.class), eq(productId),
                                eq(brandId)))
                                .thenReturn(prices);

                mockMvc.perform(get("/prices/findByParams1")
                                .param("dateTime", String.valueOf(dateTime.getTime()))
                                .param("productId", String.valueOf(productId))
                                .param("brandId", String.valueOf(brandId)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(productId))
                                .andExpect(jsonPath("$.brandId").value(brandId));
        }

        @Test
        public void testRequestAt10AMOnDay15() throws Exception {
                Date dateTime = new Date(120, 5, 15, 10, 0); // 2020-06-15 10:00
                Long productId = 35455L;
                Long brandId = 1L;

                List<Price> prices = Arrays.asList(
                                createPrice(productId, brandId, new Date(120, 5, 15, 0, 0),
                                                new Date(120, 11, 31, 23, 59, 59), 4, 3, new BigDecimal(40.0), "USD"));

                when(priceRepository.findPriceByStartDateAndProductIdAndBrandId(any(Date.class), eq(productId),
                                eq(brandId)))
                                .thenReturn(prices);

                mockMvc.perform(get("/prices/findByParams1")
                                .param("dateTime", String.valueOf(dateTime.getTime()))
                                .param("productId", String.valueOf(productId))
                                .param("brandId", String.valueOf(brandId)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(productId))
                                .andExpect(jsonPath("$.brandId").value(brandId));
        }

        @Test
        public void testRequestAt9PMOnDay16() throws Exception {
                Date dateTime = new Date(120, 5, 16, 21, 0); // 2020-06-16 21:00
                Long productId = 35455L;
                Long brandId = 1L;

                List<Price> prices = Arrays.asList(
                                createPrice(productId, brandId, new Date(120, 5, 16, 0, 0),
                                                new Date(120, 11, 31, 23, 59, 59), 5, 4, new BigDecimal(55.0), "EUR"));

                when(priceRepository.findPriceByStartDateAndProductIdAndBrandId(any(Date.class), eq(productId),
                                eq(brandId)))
                                .thenReturn(prices);

                mockMvc.perform(get("/prices/findByParams1")
                                .param("dateTime", String.valueOf(dateTime.getTime()))
                                .param("productId", String.valueOf(productId))
                                .param("brandId", String.valueOf(brandId)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(productId))
                                .andExpect(jsonPath("$.brandId").value(brandId));
        }

        private Price createPrice(Long productId, Long brandId, Date startDate, Date endDate, Integer priceList,
                        Integer priority,
                        BigDecimal price, String currency) {
                Price priceObj = new Price();
                priceObj.setProductId(productId);
                priceObj.setBrandId(brandId);
                priceObj.setStartDate(startDate);
                priceObj.setEndDate(endDate);
                priceObj.setPriceList(priceList);
                priceObj.setPriority(priority);
                priceObj.setPrice(price);
                priceObj.setCurrency(currency);
                return priceObj;
        }
}
