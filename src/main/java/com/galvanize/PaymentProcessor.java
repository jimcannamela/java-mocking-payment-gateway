package com.galvanize;

public interface PaymentProcessor {
	boolean makePayment(String orderNumber, Double amount);
}
