package com.liaotuo.springcloud.controller;

import com.liaotuo.springcloud.entities.CommonResult;
import com.liaotuo.springcloud.entities.Payment;
import com.liaotuo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    @ResponseBody
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert result: " + result);

        if (result > 0) {
            return new CommonResult(0, "insert success", result);
        } else {
            return new CommonResult(-1, "insert failed");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("get result: " + payment);

        if (payment != null) {
            return new CommonResult(0, "get success", payment);
        } else {
            return new CommonResult(-1, "get failed");
        }
    }
}
