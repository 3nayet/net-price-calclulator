package com.demo.netpricecalculator.controllers;

import com.demo.netpricecalculator.controllers.mapper.PriceCalculatorMapper;
import com.demo.netpricecalculator.controllers.requestparam.PriceRequest;
import com.demo.netpricecalculator.controllers.restmodels.AvailableCountriesRestModel;
import com.demo.netpricecalculator.controllers.restmodels.NetPriceRestModel;
import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.NetPriceEntity;
import com.demo.netpricecalculator.domain.ports.inbound.PriceService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
@Validated
public class PriceCalculatorController {
    /**
     * instantiating a logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceCalculatorController.class);

    private final PriceService priceService;
    private final PriceCalculatorMapper mapper;
    @Autowired
    public PriceCalculatorController(PriceService priceService, PriceCalculatorMapper mapper){
        this.priceService = priceService;
        this.mapper = mapper;
    }

    @GetMapping(path = "/net_price", produces = MediaType.APPLICATION_JSON_VALUE)
    public NetPriceRestModel getNetPrice(@Valid PriceRequest request){
        LOGGER.debug(" net_price was called");
        NetPriceEntity entity = priceService.calculateNetPrice(request.getPrice(), request.getCountry());
        return mapper.map(entity);
    }

    @GetMapping(path="/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public AvailableCountriesRestModel getAvailableCountries(){
        LOGGER.debug(" countries was called");
        AvailableCountriesEntity entity = priceService.getAvailableCountries();
        return mapper.map(entity);
    }
}
