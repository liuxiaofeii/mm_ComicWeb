package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.domain.OrderDetail;
import com.mm.mapper.OrderDetailMapper;
import com.mm.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public BaseDao<OrderDetail> getBaseDao() {
        return orderDetailMapper;
    }
}
