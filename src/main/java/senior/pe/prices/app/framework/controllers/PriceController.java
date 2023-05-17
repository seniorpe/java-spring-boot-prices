package senior.pe.prices.app.framework.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import senior.pe.prices.app.application.services.PriceService;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static senior.pe.prices.shared.util.BuildResponse.customResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("prices/")
public class PriceController {
    @NonNull
    private PriceService priceService;

    @GetMapping("findByParams")
    public ResponseEntity<?> findByParams(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return customResponse(priceService.findByParams(productId, brandId, date), HttpStatus.OK);
    }

    @GetMapping("findByParams1")
    public ResponseEntity<?> findByParams1(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTime) {
        return customResponse(priceService.findByParams1(productId, brandId, dateTime), HttpStatus.OK);
    }
}
