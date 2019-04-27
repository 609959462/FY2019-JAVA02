package Ppf.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Ppf.common.Const;
import Ppf.common.ServerResponse;
import Ppf.pojo.Student;

/**
 * Servlet Filter implementation class StudentLoginFilter
 */
@WebFilter("/choice")
public class StudentLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StudentLoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		//过滤：是否登陆
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpSession session=_request.getSession();//创建会话
		Student student=(Student)session.getAttribute("student");
		if(student==null) {
			PrintWriter pw=response.getWriter();
			String responseText =ServerResponse.createServerResponseByFail(Const.NO_LOGIN, "未登录").obj2str();
			pw.write(responseText);
			pw.close();
			return;
		}
		
		chain.doFilter(request, response); 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
