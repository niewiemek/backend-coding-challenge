package com.engagetech.codingchallenge.service;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class VatServiceTest {

    private VatService vatService = new VatService();

    @Before
    public void init() {
        vatService.vat = BigDecimal.valueOf(20);
        vatService.init();
    }

    @Test
    public void calculateVatFrom100() {

        BigDecimal vat = vatService.calculateFromGross(BigDecimal.valueOf(120));

        BigDecimal expected = BigDecimal.valueOf(20).setScale(2);
        assertThat(vat).isEqualTo(expected);
    }

    @Test
    public void calculateVatWithFractions() {

        BigDecimal vat = vatService.calculateFromGross(BigDecimal.valueOf(113.99));

        BigDecimal expected = BigDecimal.valueOf(19).setScale(2);
        assertThat(vat).isEqualTo(expected);
    }

    @Test
    public void calculateVatWithFractionsBelowHalf() {
        BigDecimal vat = vatService.calculateFromGross(BigDecimal.valueOf(13.29));

        assertThat(vat).isEqualTo(BigDecimal.valueOf(2.22));
    }

    @Test
    public void calucateVatWithFractions1() {
        BigDecimal vat = vatService.calculateFromGross(BigDecimal.valueOf(99.89));

        assertThat(vat).isEqualTo(BigDecimal.valueOf(16.65));
    }

    @Test
    public void calucateVatWithFractions2() {
        BigDecimal vat = vatService.calculateFromGross(BigDecimal.valueOf(45.22));

        assertThat(vat).isEqualTo(BigDecimal.valueOf(7.54));
    }
}