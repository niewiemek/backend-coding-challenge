package com.engagetech.codingchallenge.service;

import com.engagetech.codingchallenge.Application;
import com.engagetech.codingchallenge.common.ExchangeRates;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ExchangeRateFacadeIntegrationTest {

    @Autowired
    private ExchangeRateFacade exchangeRateFacade;

    @Test
    public void exchangeLatestRate() throws Exception {

        ExchangeRates exchangeRates = exchangeRateFacade.exchangeLatestRate("GBP");


        assertThat(exchangeRates)
                .isNotNull()
                .hasFieldOrPropertyWithValue("base", "GBP");

        assertThat(exchangeRates.getDate()).isInSameDayAs(createLastWorkingDay());

        assertThat(exchangeRates.getRates())
                .isNotEmpty()
                .containsKeys("EUR", "PLN", "USD");
    }

    private Date createLastWorkingDay() {
        Calendar today = Calendar.getInstance();
        switch (today.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                today.add(Calendar.DAY_OF_MONTH, -2);
                break;
            case Calendar.MONDAY:
                today.add(Calendar.DAY_OF_MONTH, -3);
                break;
            default:
                today.add(Calendar.DAY_OF_MONTH, -1);
                break;
        }

        return today.getTime();
    }

}