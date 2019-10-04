package com.qjx.dp.strategy;

import com.qjx.dp.strategy.entity.dto.OrderDTO;
import com.qjx.dp.strategy.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Resource
    private OrderService orderService ;

    @Test
    public void testType(){
        OrderDTO dto = new OrderDTO();
        dto.setCode("1");
        dto.setPrice(200.0);
        dto.setType("1");
        String result = orderService.handle(dto);
        System.out.println(result);

    }

}
