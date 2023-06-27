package com.galvanize;

public interface OrderRepository {
	boolean getOrder(String orderNumber);
	Double getOrderAmount(String orderNumber);
}
