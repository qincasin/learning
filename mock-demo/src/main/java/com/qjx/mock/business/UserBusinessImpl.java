package com.qjx.mock.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by qincasin on 2020/12/29.
 */
@Component
@Slf4j
public class UserBusinessImpl implements UserBusiness{
    @Override
    public Integer getUserId(Integer id) {
        log.info("getUserId id:{}",id);
        return 123;
    }
}
