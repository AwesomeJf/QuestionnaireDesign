package com.questionnaire.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(filterName="EncodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter {


    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		//System.out.println("过滤器");
		String url = ((HttpServletRequest) request).getServletPath();
		if (url.endsWith(".css") || url.endsWith(".js")){		
			chain.doFilter(request, response);	//传给下个filter处理	
		}
		else {
			request.setCharacterEncoding("utf-8"); //将编码改为utf-8
			response.setCharacterEncoding("utf-8"); 
			response.setContentType("text/html;charset=utf-8");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	


}
