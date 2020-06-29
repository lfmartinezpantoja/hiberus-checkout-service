package com.hiberus.checkout.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.checkout.service.BillServiceClient;
import com.hiberus.checkout.service.CheckoutService;
import com.hiberus.checkout.service.ClientServiceClient;
import com.hiberus.checkout.service.LogisticServiceClient;
import com.hiberus.commons.dto.BillDTO;
import com.hiberus.commons.dto.ClientDTO;
import com.hiberus.commons.dto.LogisticDTO;
import com.hiberus.commons.dto.OrderDTO;
import com.hiberus.commons.dto.OrderResponseDTO;
import com.hiberus.commons.expection.CustomException;

import lombok.extern.java.Log;

@Log
@Service
public class CheckoutServiceImp implements CheckoutService {

	@Autowired
	ClientServiceClient clientService;

	@Autowired
	BillServiceClient billService;

	@Autowired
	LogisticServiceClient logisticService;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public OrderResponseDTO sendOrder(OrderDTO orderDTO) throws CustomException {
		log.info("INPUT DATA REQUEST: " + orderDTO);
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
		LogisticDTO logisticDTO = new LogisticDTO();
		ClientDTO clientDTO = clientService.getClient(orderDTO.getClientId()).getBody();
		logisticDTO.setClientName(clientDTO.getFirstName() + " " + clientDTO.getLastName());
		logisticDTO.setClientIdentification(Integer.parseInt(clientDTO.getIdentificationNumber()));
		logisticDTO.setAddress(orderDTO.getDirection());
		BillDTO billDTO = billService.generateBill(orderDTO).getBody();
		logisticDTO.setTotalAmount(billDTO.getTotalAmmount());
		logisticDTO.setBillId(billDTO.getBillid());
		logisticDTO.setTotalProducts(billDTO.getTotalProducts());
		orderResponseDTO = logisticService.logistic(logisticDTO).getBody();
		log.info("OUTPUT DATA REQUEST: " + orderDTO);
		return orderResponseDTO;
	}

}
