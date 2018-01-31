package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.common.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class CurrencyCalculator {

    private static final String GBP_CODE = "GBP";

    @Autowired
    private ExchangeRateFacade exchangeRateFacade;

    private BigDecimal convertToGBP(BigDecimal ammount, String currency) {
        if(GBP_CODE.equalsIgnoreCase(currency)) {
            return ammount;
        }

        ExchangeRates exchangeRates = exchangeRateFacade.exchangeLatestRate(currency);
        BigDecimal rate = DecimalFormat. (exchangeRates.getRates().get(currency.toUpperCase()));

        return ammount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
