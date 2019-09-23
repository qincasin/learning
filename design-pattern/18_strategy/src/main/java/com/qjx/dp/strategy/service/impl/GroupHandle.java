package com.qjx.dp.strategy.service.impl;

import com.qjx.dp.strategy.annotation.HandlerType;
import com.qjx.dp.strategy.entity.dto.OrderDTO;
import com.qjx.dp.strategy.service.AbstractHandle;
import org.springframework.stereotype.Component;

/**
 * 处理团队handler
 *
 *
 * @author: qincasin
 * @date: 2019/9/23/ 13:47
 */
@Component
@HandlerType("2")
public class GroupHandle extends AbstractHandle {
    @Override
    public String handle(OrderDTO dto) {
        return "处理团队订单";
    }
}
