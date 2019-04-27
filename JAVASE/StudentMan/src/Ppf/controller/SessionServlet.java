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

/**���½
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
		HttpSession session=request.getSession();   //ͨ��request��get�ͻᴴ��һ���ỰHttpSession
		//String JESSIONID=session.getId(); //TOKEN
		//System.out.println("sessionServlet sessinid:"+JESSIONID);
		
		
		
		//�ж��û��Ƿ��¼��
		
		Object o=session.getAttribute("user");        
		//System.out.println(o);
		
		
		
		
		Cookie[] cookies=request.getCookies();           //��ȡcookies������ֵ��cookies[]
		
		String username=null;
		String password=null;
		if(cookies!=null) {
			                                       
			for(int i=0;i<cookies.length;i++) {         //�ǿ��ж�
				Cookie cookie=cookies[i];
				String cookie_name=cookie.getName();     //��ȡ���֣�cookies�ķ�����
				String cookie_value=cookie.getValue();//��ȡcookie��ֵ����ֵ�ԣ�
				if(cookie_name.equals("username")) {  //Ҫ��cookie��username��
					username=cookie_value;          //ֵ�����û���
				}
				if(cookie_name.equals("password")) {
					password=cookie_value;
				}
				
			}
			
		}
		
		//���˺������ֱ�ӵ��õ�½�ķ������൱��������½
		if(username!=null&&password!=null) {
			
			IAdminService service=new AdminService();
			ServerResponse serverResponse = null;
			try {
				serverResponse = service.login(username, password);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//����login
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
