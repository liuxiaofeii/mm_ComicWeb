package com.mm.service.impl;

import com.mm.base.BaseDao;
import com.mm.base.BaseService;
import com.mm.base.BaseServiceImpl;
import com.mm.mapper.BookMapper;
import com.mm.service.BookService;
import com.mm.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public BaseDao<Book> getBaseDao() {
        return bookMapper;
    }
}
