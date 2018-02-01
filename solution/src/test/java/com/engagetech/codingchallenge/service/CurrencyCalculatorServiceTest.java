package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.common.ExchangeRates;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyCalculatorServiceTest {

    @InjectMocks
    private CurrencyCalculatorService currencyCalculatorService;

    @Mock
    private ExchangeRateFacade exchangeRateFacade;

    @Test
    public void convertFromGBP() {

        BigDecimal gbpAmmount = currencyCalculatorService.convertToGBP(BigDecimal.TEN, "GBP");

        assertThat(gbpAmmount).isEqualByComparingTo(BigDecimal.TEN);
        verifyZeroInteractions(exchangeRateFacade);
    }

    @Test
    public void convertFromEUR() {
        ExchangeRates exchangeRates = new ExchangeRates("GBP", new Date(), ImmutableMap.of("EUR", "2", "PLN", "3"));
        when(exchangeRateFacade.exchangeLatestRate("GBP")).thenReturn(exchangeRates);

        BigDecimal gbpAmmount = currencyCalculatorService.convertToGBP(BigDecimal.TEN, "EUR");

        assertThat(gbpAmmount).isEqualByComparingTo(BigDecimal.valueOf(20));
        verify(exchangeRateFacade).exchangeLatestRate("GBP");
    }

    @Test
    public void convertWithWrongCode() {
        ExchangeRates exchangeRates = new ExchangeRates("EUR", new Date(), ImmutableMap.of("GBP", "2", "PLN", "3"));
        when(exchangeRateFacade.exchangeLatestRate("GBP")).thenReturn(exchangeRates);


        Throwable throwable = catchThrowable(() -> currencyCalculatorService.convertToGBP(BigDecimal.TEN, "XYZ"));

        assertThat(throwable)
                .hasMessage("A non traded currency pair or wrong source currency.");
    }
}