package Ppf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Ppf.Daoimpl.RegisterDaoImpl;
import Ppf.Exception.LoginException;

import Ppf.common.OperationEnum;
import Ppf.common.ServerResponse;
import Ppf.impl.AdminService;
import Ppf.impl.CourseServiceimp;
import Ppf.pojo.Admin;
import Ppf.service.IAdminService;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin.do")
public class AdminServelt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * �������Ա������----��½ע��
     * @see HttpServlet#HttpServlet()
     */
    public AdminServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");                        //��֤��������
		response.setContentType("text/html;charset=UTF-8");           //���������ڴ���ĵ�һ�䣨��ֹ���룩	
		ServletContext serverContext=request.getServletContext();
//		PrintWriter pw1=response.getWriter();
//		ServletContext servletContext=request.getServletContext();      //��ȡȫ����
//		Integer total=(Integer)servletContext.getAttribute("total");
//		if(total==null) {
//			total=1;      //��ʱû������----�����1
//			servletContext.setAttribute("total", 1);
//		}else {
//			servletContext.setAttribute("total", ++total);
//		}
//		pw1.write("��������"+total);
		
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(10);//����һ���Ự
		
		// TODO Auto-generated method stub
		//request.getMethod();
			
		//operation:1��½  2ע��
		
		String operation= request.getParameter("operation");             //��ȡ����operation
		 
		PrintWriter pw=response.getWriter();
		if(operation==null) {
			//String responseText="{\"status\":3,\"msg\":\"������ѡ��\"}";                    //josn��ʽ
			//����Ҫ����ServerResponse
			String responseText=ServerResponse.createServerResponseByFail(3, "������ѡ��").obj2str();
			pw.write(responseText);                                                       //��ӦServerResponse��ȥ
			pw.close();
		}
		try {
			IAdminService service=new AdminService();
			int _operation=Integer.parseInt(operation);                 //����operation���Ǹ�"123"���ַ��������NumberFormatException
			//if(_operation==1) {                                        ����д��ά���Ի�Ƚϵͣ�����д��ö����Ƚ�����ά��
			if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {	
				//��½
//			String responseText="{\"status\":0,\"msg\":\"��½\"}";                    //josn��ʽ ��\ת����ǡ�����
//			pw.write(responseText);                                                       //��Ӧ��ȥ
				//pw.close();
								
				
				
				String username =request.getParameter("username");							
				String password=request.getParameter("password"); 
				
				ServerResponse<Admin> serverResponse=service.login(username, password);		//�жϵ�½�ɹ���ֱ����serverResponse�ж�		
				if(serverResponse.isSucess()) {                     //�����½�ɹ�
		    		//��¼�ɹ�					
					session.setAttribute("user", serverResponse.getData());         //�����ж��Ƿ��½��������session��JOSNIDЯ�������ݣ�
		    		//�Ự����������
		    		//System.out.print(session.getAttribute("user"));
		    		
		    		//����cooke
		    		Cookie username_cookie=new Cookie("username",username);//����Cookie   value���Ǵ��������Ǹ�
		    		//����cookie�Ĺ���ʱ��
		    		username_cookie.setMaxAge(7*24*3600);                       //ʱ��
		    		//��cookieд���ͻ��������
		    		response.addCookie(username_cookie);						//��cookieд���ͻ���
		    		
		    		Cookie password_cookie=new Cookie("password",password);
		    		password_cookie.setMaxAge(7*24*3600);                             //ʱ��
		    		response.addCookie(password_cookie);	   //��cookieд���ͻ���
		    	}
								
				pw.write(serverResponse.obj2str());				
//		    	if(issucc) {
//		    		
//		    		String responseText1=ServerResponse.createServerResponseByFail(0, "��½�ɹ�").obj2str();                    //josn��ʽ ��\ת����ǡ�����
//		    		pw.write(responseText1);                                                       //��Ӧ��ȥ
//					pw.close();
//		    		
//		    		//���ؿͻ��ˣ���¼�ɹ�
//		    		// {"status":0,"msg":"��¼�ɹ�",data:{}}
//					
//		    	}else{//���ؿͻ��ˣ���¼ʧ��
//		    		//{"status":1,"msg":"��¼ʧ��"}
//		    		String responseText1="{\"status\":0,\"msg\":\"�������\"}";                    //josn��ʽ ��\ת����ǡ�����
//					pw.write(responseText1);                                                       //��Ӧ��ȥ
//					pw.close();
//		    	}
				//pw.write(responseText);
				//pw.close();
				
			
			//}
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {
				//ע��
//				String responseText="{\"status\":0,\"msg\":\"��ע��\"}";  
//				pw.write(responseText);
				//pw.close();
				
				String username =request.getParameter("username");							
				String password=request.getParameter("password"); 
				
				pw.write(RegisterDaoImpl.getInstance().register(username,password).obj2str());
				pw.close();
			}
			else if(_operation==OperationEnum.ADMIN_LAYOUT.getOperation_type()) {
		    	//�˳���¼
		    	session.removeAttribute("user");
		    	
		    }else if(_operation==OperationEnum.ADMIN_GET_MEMBER.getOperation_type()) {
		    	//��ȡ��������                                                                                                           
		    	Integer total=(Integer)serverContext.getAttribute("total");
		    	//System.out.println("��������:"+total);
		    	String responseText=ServerResponse.createServerResponseBySucess("succ", total).obj2str();
		        pw.write(responseText);	
		    }}
		catch(NumberFormatException e){
			//����������
			String responseText="{\"status\":4,\"msg\":\"����������\"}";  
			pw.write(responseText);
			pw.close();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}				
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);                                       //�ŵ�һ�𣬴���дһ�ݾ�����
}
}