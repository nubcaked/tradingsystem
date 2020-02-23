package com.liangwei.tradingsystem.service;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SecurityServiceTests {

    @InjectMocks
    SecurityService securityService;

    @Mock
    SecurityRepository securityRepository;

    @Test
    public void whenDisplaySecurities_thenReturnString() {
        List<Security> securityList = new ArrayList<>();
        Security security = new Security("GOOG", "stock", 12.2, 0.12, 2.2);
        securityList.add(security);

        when(securityRepository.findAll()).thenReturn(securityList);
        String result = securityService.displaySecurities();
        assertEquals(result, "Security{ticker=GOOG, type=stock, price=12.2, strikePrice=null, maturityDate=null}");
    }
}
