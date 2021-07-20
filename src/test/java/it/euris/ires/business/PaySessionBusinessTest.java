package it.euris.ires.business;

import it.euris.ires.dataObject.BusinessData;
import it.euris.ires.dataObject.CreatePaySessionRequest;
import it.euris.ires.dataObject.CreatePaySessionResponse;
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

    @Mock
    CreatePaySessionResponse response;

    @Test
    void createPaySession() throws PaySessionException {
        // ARRANGE
        paySessionBusiness = new PaySessionBusiness(paymentSessionServiceMocked);
        CreatePaySessionRequest request = new CreatePaySessionRequest();
        PaySession paySessionGood = new PaySession();
        PaySession paySession = paymentSessionServiceMocked.createWebPaySession(request);
        Mockito.when(paymentSessionServiceMocked.createWebPaySession(any())).thenReturn(paySessionGood);
        // ACT ASSERT
        paySessionBusiness.createPaySession(request);
        //Mockito.verify(response, Mockito.times(1)).setSuccess(true);
        //Mockito.verify(response, Mockito.times(1)).setStatus(paySession.getStatus().name());
        //Mockito.verify(response, Mockito.times(1)).setPaySessionId(paySession.getUuid().toString());
    }

    @Test
    void getPaySession() {
    }
}