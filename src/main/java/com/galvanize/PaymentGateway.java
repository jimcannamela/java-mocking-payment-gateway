package com.galvanize;

public class PaymentGateway {
    private PaymentProcessor processor;
    private OrderRepository repository;

    public PaymentGateway(PaymentProcessor processor, OrderRepository repository) {
        this.processor = processor;
        this.repository = repository;
    }

    public boolean processPayment(String orderNumber) {
        Double amount = repository.getOrderAmount(orderNumber);
        return processor.makePayment(orderNumber, amount);
    }

    public boolean findOrder(String orderNumber) {
        boolean result = repository.getOrder(orderNumber);
        return result;
    }

}
