package com.demo.netpricecalculator.service;

import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.NetPriceEntity;
import com.demo.netpricecalculator.domain.ports.inbound.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PriceServiceTest {

    @Autowired
    PriceService priceService;

    @Test
    void testCalculateNetPrice(){

        NetPriceEntity entity = priceService.calculateNetPrice(new BigDecimal(10) , "it");
        assertNotNull(entity, "Response from priceService service is [ null ]");
        assertEquals(Boolean.TRUE, entity.isOk(), "Response from priceService is not Ok");
        assertEquals(0,  entity.getNetPrice().compareTo(new BigDecimal("7.90")),
                "price calculation not correct");

    }

    @Test
    void testCalculateNetPriceNullCountry(){

        NetPriceEntity entity = priceService.calculateNetPrice(new BigDecimal(10) , null);
        assertNotNull(entity, "Response from priceService service is [ null ]");
        assertEquals(Boolean.FALSE, entity.isOk(), "Response from priceService is not Ok");
        assertEquals(null,  entity.getNetPrice(), "price not set to null");

    }

    @Test
    void testCalculateNetPriceNullPrice(){

        NetPriceEntity entity = priceService.calculateNetPrice(new BigDecimal(10) , null);
        assertNotNull(entity, "Response from priceService service is [ null ]");
        assertEquals(Boolean.FALSE, entity.isOk(), "Response from priceService is not Ok");
        assertEquals(null,  entity.getNetPrice(), "price not set to null");

    }


    @Test
    void testCalculateNetPriceNegativePrice(){
        NetPriceEntity entity = priceService.calculateNetPrice(new BigDecimal(-10) , "it");
        assertNotNull(entity, "Response from priceService service is [ null ]");
        assertEquals(Boolean.FALSE, entity.isOk(), "Response from priceService is not Ok");
        assertEquals(null,  entity.getNetPrice(), "price not set to null");
    }

    @Test
    void testGetAvailableCountries(){
        AvailableCountriesEntity entity = priceService.getAvailableCountries();
        assertNotNull(entity, "Response from getAvailableCountries service is [ null ]");
        assertEquals(Boolean.TRUE, entity.isOk(), "Response from getAvailableCountries is not Ok");
        assertTrue(entity.getCountires().size()>0 , " countries list is empty");
    }
}
