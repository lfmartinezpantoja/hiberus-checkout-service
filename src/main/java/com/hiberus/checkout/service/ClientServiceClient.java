package com.hiberus.checkout.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.hiberus.commons.service.ClientFeingClient;

@FeignClient(name = "client-service", url = "${url.client.service}")
public interface ClientServiceClient extends ClientFeingClient{

}
