package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.domain.Sc;
import com.mm.mapper.ScMapper;
import com.mm.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScServiceImpl extends BaseServiceImpl<Sc> implements ScService {
    @Autowired
    ScMapper scMapper;
    @Override
    public BaseDao<Sc> getBaseDao() {
        return scMapper;
    }
}
