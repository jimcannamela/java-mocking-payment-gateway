package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentGatewayTests {
    PaymentGateway paymentGateway;

    PaymentProcessor paymentProcessor;
    OrderRepository orderRepository;

//    Can start the gateway (with mocks)
    @Test
    void canStartGateway() {
        paymentGateway = new PaymentGateway(paymentProcessor, orderRepository);
        assertNotNull(paymentGateway);
    }

//    Can process a successful payment (with mocks)

    @Test
    void canProcessSuccessfulPayment() {
        assertTrue(paymentGateway.processPayment(123));
    }

//    Can handle a failed payment (with mocks)
//    Verify that the proper methods are called upon processing (with mocks)
//    Can handle an order not found (with mocks)
//    Verify the interactions and assertions

}
