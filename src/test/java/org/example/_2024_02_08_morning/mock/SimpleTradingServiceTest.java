package org.example._2024_02_08_morning.mock;

import org.example.TESTING._2024_02_08_morning.mock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)

class SimpleTradingServiceTest {
    @Mock
    Trade trade; //Trade trade = Mockito.mock(Trade.class);
    @Mock

    TradeRepository tradeRepository;
    @Mock
    AuditService auditService;

    @Test
    void createTradeOnlyLoggingTest() {
        Mockito.when(tradeRepository.createTrade(trade)).thenReturn(Mockito.anyLong());
//        TradingService service = new SimpleTradingService(tradeRepository, auditService);
//        service.createTrade(trade);
//        Mockito.verify(auditService).logNewTrade(trade);
    }
}