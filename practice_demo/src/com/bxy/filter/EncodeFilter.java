package com.bxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个解决全站中文乱码的过滤器 
 *
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    	// 设置请求乱码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应乱码格式
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
