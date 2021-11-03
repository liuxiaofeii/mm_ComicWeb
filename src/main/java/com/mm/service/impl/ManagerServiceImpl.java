package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;

import com.mm.domain.Manager;
import com.mm.mapper.ManagerMapper;
import com.mm.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public BaseDao<Manager> getBaseDao() {
        return managerMapper;
    }
}
