package com.fleexy.springcloud.alibaba.service;

import com.fleexy.springcloud.entities.CommonResult;
import com.fleexy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(555,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
