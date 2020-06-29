package com.hiberus.checkout.service;

import com.hiberus.commons.dto.OrderDTO;
import com.hiberus.commons.dto.OrderResponseDTO;
import com.hiberus.commons.expection.CustomException;

public interface CheckoutService {

	public OrderResponseDTO sendOrder(OrderDTO orderDTO) throws CustomException;
}
