package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PriceListenerImpl implements PriceListener{
    private static final Logger LOGGER = Logger.getLogger(PriceListenerImpl.class.getName());

    private final double specifiedThreshold = 55.0;
    private final String stock = "IBM";

    private ExecutionService executionService;

    public PriceListenerImpl(ExecutionService executionService) {
        this.executionService = executionService;
    }

    @Override
    public void priceUpdate(String security, double price) {
        LOGGER.log(Level.INFO, "In price update method>>>>>>>>>>>");
        if(security!= null && security.equals(stock)){
            if(price < specifiedThreshold){
                LOGGER.log(Level.INFO, "Executing buy instruction for stock {0} at price {1}",  new Object[]{security, price});
                executionService.buy(security, specifiedThreshold, 100);
            }
        }
    }
}
