package com.demo.netpricecalculator.service;

import com.demo.netpricecalculator.domain.datamodels.VatEntity;
import com.demo.netpricecalculator.domain.ports.outbound.TaxProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaxProviderTest {

    @Autowired
    TaxProvider taxProvider;

    @Test
    void testGetVat(){
        VatEntity entity = taxProvider.getVat("it");
        assertNotNull(entity, "Response from taxProvider service is [ null ]");
        assertEquals(Boolean.TRUE, entity.isOk(), "Response from taxProvider is not Ok");
        assertEquals(0,  entity.getVat().compareTo(new Float(".21")),
                "vat not correct");
    }

    @Test
    void testGetVatNullCountry(){
        VatEntity entity = taxProvider.getVat(null);
        assertNotNull(entity, "Response from taxProvider service is [ null ]");
        assertEquals(Boolean.FALSE, entity.isOk(), "Response from taxProvider is not Ok");
        assertTrue(Objects.equals(entity.getVat(), null) ,
                "vat not correct");
    }
}
