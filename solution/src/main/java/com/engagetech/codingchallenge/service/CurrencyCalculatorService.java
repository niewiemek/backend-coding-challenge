package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.common.ExchangeRates;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Service
public class CurrencyCalculatorService {

    private static final String GBP_CODE = "GBP";

    @Autowired
    private ExchangeRateFacade exchangeRateFacade;

    public BigDecimal convertToGBP(BigDecimal ammount, String currency) {
        if (GBP_CODE.equalsIgnoreCase(currency)) {
            return ammount;
        }

        ExchangeRates exchangeRates = exchangeRateFacade.exchangeLatestRate(GBP_CODE);
        Preconditions.checkState(exchangeRates.getRates().containsKey(currency),
                "A non traded currency pair or wrong source currency.");
        BigDecimal rate = new BigDecimal(exchangeRates.getRates().get(currency));

        return ammount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
