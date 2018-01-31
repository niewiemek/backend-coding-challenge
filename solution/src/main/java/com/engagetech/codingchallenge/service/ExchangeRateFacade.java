package com.engagetech.codingchallenge.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Currency service is consuming fixer.io for exchange rates.
 */
@Service
public class CurrencyService {

    private RestTemplate restTemplate;
}
