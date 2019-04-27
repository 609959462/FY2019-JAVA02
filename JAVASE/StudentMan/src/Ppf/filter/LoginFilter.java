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
@WebFilter({"/student.do","/course"})                //�����ڵ������·��֮ǰ���⵽���ء� ���ض��
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
		request.setCharacterEncoding("UTF-8");                        //��֤��������
		response.setContentType("text/html;charset=UTF-8");  
		// TODO Auto-generated method stub                                    //doFilter�Ǵ������صģ��������غ󣬾ͻ�ִ��dofilter��
		// place your code here
		PrintWriter pw=response.getWriter();            		 
		HttpServletRequest _request=(HttpServletRequest)request;              //����ת�ͻ�ȡ��HttpServletRequest
		HttpSession session=_request.getSession();
		Admin admin=(Admin)session.getAttribute("user");      //�õ���½�ɹ��Ự���е�user��get�������ص���object����������ת�ͣ�		
		System.out.print(admin);
		if(admin==null) {
			String responseText=ServerResponse.createServerResponseByFail(17, "δ��¼").obj2str();
			pw.write(responseText);
			pw.close();
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);       //ִ����仰��Ҳ����ζ��ͨ��������������ִ�о�ûͨ����             
	}																//�����е�ServletRequest����HTTPServletRequest�ĸ���
																	//HTTPServletRequest����������ȡֻ���ڽ���Http�������Ӧ
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
