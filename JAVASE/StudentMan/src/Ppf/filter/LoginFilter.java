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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Ppf.common.ServerResponse;
import Ppf.pojo.Admin;

/**
 * Servlet Filter implementation class LoginFilter
 */ 
@WebFilter({"/student.do","/course"})                //请求在到达这个路径之前会遭到拦截。 拦截多个
public class LoginFilter implements Filter {

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
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");                        //保证不是乱码
		response.setContentType("text/html;charset=UTF-8");  
		// TODO Auto-generated method stub                                    //doFilter是处理拦截的（请求被拦截后，就会执行dofilter）
		// place your code here
		PrintWriter pw=response.getWriter();            		 
		HttpServletRequest _request=(HttpServletRequest)request;              //向下转型获取到HttpServletRequest
		HttpSession session=_request.getSession();
		Admin admin=(Admin)session.getAttribute("user");      //得到登陆成功会话域中的user（get方法返回的是object，所以向下转型）		
		System.out.print(admin);
		if(admin==null) {
			String responseText=ServerResponse.createServerResponseByFail(17, "未登录").obj2str();
			pw.write(responseText);
			pw.close();
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);       //执行这句话，也就意味着通过了拦截器（不执行就没通过）             
	}																//参数中的ServletRequest，是HTTPServletRequest的父类
																	//HTTPServletRequest就是用来获取只用于接收Http请求和响应
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
