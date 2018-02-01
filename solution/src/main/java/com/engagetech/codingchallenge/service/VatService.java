package com.engagetech.codingchallenge.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * This class should be deleted after implementation was moved to front-end as it's obsolete.
 * I have left if for just for reference.
 *
 */
@Service
public class VatService {

    @Value("${vat}")
    private BigDecimal vat;

    private BigDecimal vatAsDecimal = null;

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public BigDecimal calculateFromGross(BigDecimal grossPrice) {

        BigDecimal netPrice = calculateNetPrice(grossPrice);

        return grossPrice.subtract(netPrice);
    }

    private BigDecimal calculateNetPrice(BigDecimal value) {
        return value.divide(vatAsDecimal, 2, BigDecimal.ROUND_DOWN);
    }

    @PostConstruct
    void init() {
        vatAsDecimal = BigDecimal.ONE.add(vat.divide(HUNDRED));
    }
}
