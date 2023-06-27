package com.galvanize;

public interface OrderRepository {
	default boolean getOrder(String orderNumber) {
		return true;
	}
}
