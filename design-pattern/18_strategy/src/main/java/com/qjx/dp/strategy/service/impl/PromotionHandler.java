package com.qjx.dp.strategy.service.impl;

import com.qjx.dp.strategy.annotation.HandlerType;
import com.qjx.dp.strategy.entity.dto.OrderDTO;
import com.qjx.dp.strategy.service.AbstractHandle;
import org.springframework.stereotype.Component;

/**
 * 处理促销订单
 *
 *
 * @author: qincasin
 * @date: 2019/9/23/ 13:52
 */
@Component
@HandlerType("3")
public class PromotionHandler extends AbstractHandle {
    @Override
    public String handle(OrderDTO dto) {

        return "处理普通订单";
    }
}
