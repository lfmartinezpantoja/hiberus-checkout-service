package com.hiberus.checkout.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.hiberus.commons.service.LogisticFeingClient;

@FeignClient(name = "logistic-service", url = "${url.logistic.service}")
public interface LogisticServiceClient extends LogisticFeingClient{

}
