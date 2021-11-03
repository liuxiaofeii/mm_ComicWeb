package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseServiceImpl;
import com.mm.mapper.ContentMapper;
import com.mm.service.ContentService;
import com.mm.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {
    @Autowired
    ContentMapper contentMapper;
    @Override
    public BaseDao<Content> getBaseDao() {
        return contentMapper;
    }
}
