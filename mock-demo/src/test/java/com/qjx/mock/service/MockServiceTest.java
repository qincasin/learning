package com.qjx.mock.service;

import com.alibaba.testable.core.annotation.MockMethod;
import com.alibaba.testable.core.annotation.MockWith;
import com.alibaba.testable.core.model.MockDiagnose;
import com.qjx.mock.business.UserBusiness;
import com.qjx.mock.business.UserBusinessImpl;
import com.qjx.mock.service.imp.MockServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by qincasin on 2020/12/29.
 */
@Slf4j
@MockWith(diagnose = MockDiagnose.ENABLE)
public class MockServiceTest {

    @MockMethod
    int getUserId(UserBusiness userBusiness){return 1;}

    @Test
    public void test(){
        Integer id = 123;
        MockServiceImpl impls = new MockServiceImpl();
        String result = impls.mock(id);
        log.info("test result:{}",result);
//        assert equals(1);

    }

    @Test
    public void test2(){
        log.info("1111111");
    }


}
