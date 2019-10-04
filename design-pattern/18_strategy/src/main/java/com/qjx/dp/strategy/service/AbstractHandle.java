package com.qjx.dp.strategy.service;

import com.qjx.dp.strategy.entity.dto.OrderDTO;

public abstract class AbstractHandle {
    abstract public String handle(OrderDTO dto);
}
