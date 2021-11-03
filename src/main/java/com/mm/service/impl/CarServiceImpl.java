package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.domain.Car;
import com.mm.mapper.CarMapper;
import com.mm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {
    @Autowired
    CarMapper carMapper;
    @Override
    public BaseDao<Car> getBaseDao() {
        return carMapper;
    }
}
