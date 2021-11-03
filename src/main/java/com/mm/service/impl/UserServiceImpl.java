package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.mapper.UserMapper;
import com.mm.service.UserService;
import com.mm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public BaseDao<User> getBaseDao() {
        return userMapper;
    }
}
