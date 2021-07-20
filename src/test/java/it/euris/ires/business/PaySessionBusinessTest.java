package it.euris.ires.business;

import it.euris.ires.dataObject.*;
import it.euris.ires.entity.PaySession;
import it.euris.ires.exception.PaySessionException;
import it.euris.ires.service.IPaymentSessionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PaySessionBusinessTest {

    PaySessionBusiness paySessionBusiness;

    @Mock
    IPaymentSessionService paymentSessionServiceMocked;

    @BeforeEach
    void setUp() {
        paySessionBusiness = new PaySessionBusiness(paymentSessionServiceMocked);
    }

    @Spy
    CreatePaySessionResponse response;

    @Test
    void createPaySession() throws PaySessionException {
        // ARRANGE
        paySessionBusiness = new PaySessionBusiness(paymentSessionServiceMocked);
        CreatePaySessionRequest request = new CreatePaySessionRequest();
        SaleItem item1 = new SaleItem("name","description","productid","variantid","1000", 2);
        List<SaleItem> items = new ArrayList<>();
        items.add(item1);
        request.setSaleItems(items);
        request.setTaxAmount("10");
        BusinessData businessData = new BusinessData("accountID", "paymentconfigID","consumerID");
        request.setBusinessData(businessData);
        PaySessionSettings paySessionSettings = new PaySessionSettings(10,false,false,"euro","english");
        request.setPaySessionSettings(paySessionSettings);
        // ACT
        CreatePaySessionResponse createPaySessionResponse= paySessionBusiness.createPaySession(request);
        // ASSERT
        //Mockito.verify(response, Mockito.times(1)).setSuccess(true);
        //Mockito.verify(response, Mockito.times(1)).setStatus(paySession.getStatus().name());
        //Mockito.verify(response, Mockito.times(1)).setPaySessionId(paySession.getUuid().toString());
    }

    @Test
    void getPaySession() {
    }
}