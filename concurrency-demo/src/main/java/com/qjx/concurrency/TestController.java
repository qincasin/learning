package com.qjx.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test(){
        log.info("test测试成功");
        return "test";
    }


}
