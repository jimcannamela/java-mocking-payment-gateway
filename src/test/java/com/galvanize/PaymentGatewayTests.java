package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class PaymentGatewayTests {

    PaymentGateway paymentGateway;
//    @Mock
    OrderRepository orderRepository;
    PaymentProcessor paymentProcessor;
    @BeforeEach
    void setUp() {
        paymentProcessor = mock(PaymentProcessor.class);
        orderRepository = mock(OrderRepository.class);
        paymentGateway = new PaymentGateway(paymentProcessor, orderRepository);
    }

    //    Can start the gateway (with mocks)
    @Test
    void canStartGateway() {
        assertNotNull(paymentGateway);
    }

    //    Can process a successful payment (with mocks)
    @Test
    void canProcessSuccessfulPayment() {
        when(paymentProcessor.makePayment(123))
                .thenReturn(true);
        boolean result = paymentGateway.processPayment(123);
        assertTrue(result);
        verify(paymentProcessor, atLeast(1)).makePayment(123);
    }
    //    Can handle a failed payment (with mocks)
    @Test
    void canProcessFailedPayment() {
        when(paymentProcessor.makePayment(123))
                .thenReturn(false);
        boolean result = paymentGateway.processPayment(123);
        assertFalse(result);
        verify(paymentProcessor, atLeast(1)).makePayment(123);
    }
    //    Verify that the proper methods are called upon processing (with mocks)
    //         See above tests added verify, SDFW!
    //    Can handle an order not found (with mocks)
    @Test
    void handleOrderNotFound() {
        when(orderRepository.getOrder("OU812"))
                .thenReturn(false);
        boolean result = paymentGateway.findOrder("OU812");
        assertFalse(result);
        verify(orderRepository, atLeast(1)).getOrder("OU812");
    }
    //    Verify the interactions and assertions

}