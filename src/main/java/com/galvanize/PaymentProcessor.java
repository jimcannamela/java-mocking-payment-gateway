package com.galvanize;

public interface PaymentProcessor {
	default boolean makePayment(int amount) {
		return true;
	}
}
