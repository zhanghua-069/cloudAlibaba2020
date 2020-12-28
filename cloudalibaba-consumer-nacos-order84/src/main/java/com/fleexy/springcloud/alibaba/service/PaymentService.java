package com.fleexy.springcloud.alibaba.service;

import com.fleexy.springcloud.entities.CommonResult;
import com.fleexy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = PaymentService.SERVICE_NAME, fallback = PaymentFallbackService.class)
public interface PaymentService {

    String SERVICE_NAME = "nacos-payment-provider";

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
