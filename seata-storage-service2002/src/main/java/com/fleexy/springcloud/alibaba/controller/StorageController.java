package com.fleexy.springcloud.alibaba.controller;

import com.fleexy.springcloud.alibaba.domain.CommonResult;
import com.fleexy.springcloud.alibaba.domain.Storage;
import com.fleexy.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam(value = "productId", required = true) Long productId,
                                 @RequestParam(value = "count", required = true) Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
