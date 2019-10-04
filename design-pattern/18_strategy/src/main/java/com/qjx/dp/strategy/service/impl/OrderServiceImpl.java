package com.qjx.dp.strategy.service.impl;

import com.qjx.dp.strategy.config.HandlerContext;
import com.qjx.dp.strategy.entity.dto.OrderDTO;
import com.qjx.dp.strategy.service.AbstractHandle;
import com.qjx.dp.strategy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: qincasin
 * @date: 2019/9/20/ 15:06
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private HandlerContext handlerContext;


    @Override
    public String handle(OrderDTO dto) {
        AbstractHandle handle = handlerContext.getInstance(dto.getType());
        return handle.handle(dto);
    }
}
