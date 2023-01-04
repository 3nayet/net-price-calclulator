package com.demo.netpricecalculator.controllers.mapper;

import com.demo.netpricecalculator.controllers.restmodels.AvailableCountriesRestModel;
import com.demo.netpricecalculator.controllers.restmodels.NetPriceRestModel;
import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.NetPriceEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceCalculatorMapper {
    public NetPriceRestModel map(NetPriceEntity entity){
        return Optional.ofNullable(entity).map(e ->  new NetPriceRestModel(entity.isOk(), entity.getErrMessage(),
                entity.getNetPrice())).orElse(null);
    }

    public AvailableCountriesRestModel map(AvailableCountriesEntity entity){
        return Optional.ofNullable(entity).map(e ->  new AvailableCountriesRestModel(entity.isOk(),
                entity.getErrMessage(), entity.getCountires())).orElse(null);
    }
}
