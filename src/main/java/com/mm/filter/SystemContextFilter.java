package com.mm.filter;

import com.mm.util.SystemContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SystemContextFilter implements Filter {
    /**
     * 该过滤器结合ThreadLocal使用，ThreadLocal可以令本次线程的数据不会丢失；
     * 所以可以在这个过滤器里获取pageOffset的值，传给下个页面，但该次请求结束，
     * 回收线程资源
     */
    private Integer pageSize;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        Integer offset = 0;
//        try {
//            offset = Integer.parseInt(req.getParameter("pager.offset"));
//        } catch (NumberFormatException e) {
//        }
//        try {
//            SystemContext.setOrder(req.getParameter("order"));
//            SystemContext.setSort(req.getParameter("sort"));
//            SystemContext.setPageOffset(offset);
//            SystemContext.setPageSize(pageSize);
//            SystemContext.setRealPath(((HttpServletRequest) req).getSession().getServletContext().getRealPath("/"));
//            chain.doFilter(req, resp);
//        } finally {
//            SystemContext.removeOrder();
//            SystemContext.removeSort();
//            SystemContext.removePageOffset();
//            SystemContext.removePageSize();
//            SystemContext.removeRealPath();
//        }
        Integer offset=0;
        try {
            offset = Integer.parseInt(req.getParameter("pager.offset"));
        }catch (NumberFormatException e){}
        try {
            SystemContext.setPageOffset(offset);
            chain.doFilter(req,resp);
        }finally {
            SystemContext.removeOrder();
            SystemContext.removeSort();
            SystemContext.removePageOffset();
            SystemContext.removePageSize();
            SystemContext.removeRealPath();
        }


    }

    @Override
    public void destroy() {

    }
}
