package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseService;
import com.mm.base.BaseServiceImpl;
import com.mm.domain.Order;
import com.mm.mapper.OrderMapper;
import com.mm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public BaseDao<Order> getBaseDao() {
        return orderMapper;
    }
}
