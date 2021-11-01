package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListenerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

    @Mock
    private ExecutionService service;

    @InjectMocks
    private PriceListenerImpl priceListenerImpl = new PriceListenerImpl(service);

    @Test
    public void testPriceUpdate_BelowPrice() {
        priceListenerImpl.priceUpdate("IBM", 50);
    }

    @Test
    public void testPriceUpdate_notBelowPrice() {
        priceListenerImpl.priceUpdate("IBM", 60);
    }
}
