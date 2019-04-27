package Ppf.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Ppf.Exception.LoginException;
import Ppf.common.ServerResponse;
import Ppf.impl.AdminService;
import Ppf.service.IAdminService;

/**免登陆
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session.do")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();   //通过request的get就会创建一个会话HttpSession
		//String JESSIONID=session.getId(); //TOKEN
		//System.out.println("sessionServlet sessinid:"+JESSIONID);
		
		
		
		//判断用户是否登录过
		
		Object o=session.getAttribute("user");        
		//System.out.println(o);
		
		
		
		
		Cookie[] cookies=request.getCookies();           //获取cookies，返回值是cookies[]
		
		String username=null;
		String password=null;
		if(cookies!=null) {
			                                       
			for(int i=0;i<cookies.length;i++) {         //非空判断
				Cookie cookie=cookies[i];
				String cookie_name=cookie.getName();     //获取名字（cookies的方法）
				String cookie_value=cookie.getValue();//获取cookie的值（键值对）
				if(cookie_name.equals("username")) {  //要找cookie叫username的
					username=cookie_value;          //值就是用户名
				}
				if(cookie_name.equals("password")) {
					password=cookie_value;
				}
				
			}
			
		}
		
		//获账号密码就直接调用登陆的方法，相当于替它登陆
		if(username!=null&&password!=null) {
			
			IAdminService service=new AdminService();
			ServerResponse serverResponse = null;
			try {
				serverResponse = service.login(username, password);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//调用login
			response.getWriter().write(serverResponse.obj2str());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
