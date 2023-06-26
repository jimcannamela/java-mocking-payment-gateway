package com.galvanize;

public class PaymentGateway {
    private PaymentProcessor processor;
    private OrderRepository repository;

    public PaymentGateway(PaymentProcessor processor, OrderRepository repository) {
        this.processor = processor;
        this.repository = repository;
    }

    public boolean processPayment(int dollars) {
        return false;
    }
}
