package com.fleexy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t------testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");*/

        log.info("testD 测试异常比例");
        int a = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int a = 10/0;
        return "------testE 测试异常数";
    }

    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    @GetMapping("/testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
//        int a = 10/0;
        return "------testHotkey";
    }

    // 兜底方法
    public String deal_testHotkey(String p1, String p2, BlockException exception) {
        return "------deal_testHotkey, o(╥﹏╥)o";
    }

    @GetMapping("/testLink/{id}")
    public String testLink(@PathVariable("id") Integer id) {
        if(id % 2 == 0) {
            return restTemplate.getForObject("http://cloudalibaba-sentinel-service/testA", String.class);
        }
        return "------testLink";
    }
}