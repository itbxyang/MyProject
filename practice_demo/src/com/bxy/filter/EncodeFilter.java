package com.bxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ�����ȫվ��������Ĺ����� 
 *
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    	// �������������ʽ
        req.setCharacterEncoding("utf-8");
        // ������Ӧ�����ʽ
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
