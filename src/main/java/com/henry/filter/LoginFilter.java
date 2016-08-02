package com.henry.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.henry.entity.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns={"/user/*", "/note/*", "/notebook/*"})
public class LoginFilter implements Filter {

	Logger logger = Logger.getLogger(LoginFilter.class);
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest requ, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String ajaxHeader = request.getHeader("x-requested-with");//AJAX
		if(user==null && ajaxHeader==null) {
			logger.info("LoginFilter works");
			response.sendRedirect(request.getContextPath() + "/Login.html");
			return;
		}
		chain.doFilter(requ, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
