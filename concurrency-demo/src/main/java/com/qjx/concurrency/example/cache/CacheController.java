package com.qjx.concurrency.example.cache;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    @Resource
    private RedisClient redisClient;
    @PostMapping("/set")
    public String set(String key,String value) throws Exception{
        redisClient.set(key,value);
        return "success";
    }
    @PostMapping("/get")
    public String get(String key) throws Exception{
        return redisClient.get(key);
    }
}
