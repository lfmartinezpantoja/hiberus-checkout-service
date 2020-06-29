package com.hiberus.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.checkout.service.CheckoutService;
import com.hiberus.commons.dto.OrderDTO;
import com.hiberus.commons.dto.OrderResponseDTO;
import com.hiberus.commons.expection.CustomException;

@RestController
public class CheckoutController {

	@Autowired
	CheckoutService checkoutService;

	@PostMapping("checkout")
	public ResponseEntity<OrderResponseDTO> sendOrder(@RequestBody OrderDTO orderDTO) throws CustomException {
		return new ResponseEntity<>(checkoutService.sendOrder(orderDTO), HttpStatus.OK);
	}

}
