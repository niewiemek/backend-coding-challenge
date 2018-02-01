package com.engagetech.codingchallenge.service;


import com.engagetech.codingchallenge.common.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Currency service is consuming fixer.io for exchange rates.
 */
@Service
public class ExchangeRateFacade {

    @Value("${exchangerate.endpoint}")
    private String exchangeServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ExchangeRates exchangeLatestRate(String baseCurrency) {
        return restTemplate.getForObject(exchangeServiceUrl+"?base="+baseCurrency, ExchangeRates.class);
    }
}
