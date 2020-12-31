package com.qjx.mock.service.imp;

import com.qjx.mock.business.UserBusiness;
import com.qjx.mock.service.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qincasin on 2020/12/29.
 */
@Service
@Slf4j
public class MockServiceImpl implements MockService {

    @Autowired
    private UserBusiness userBusiness;

    @Override
    public String mock(int id) {
        log.info("mock req:{}", id);
        Integer result = userBusiness.getUserId(id);
        log.info("result:{}", result);
        return result.toString();
    }
}
