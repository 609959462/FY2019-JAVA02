package Ppf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Ppf.Daoimpl.AdminByCourse;
import Ppf.common.ServerResponse;
import Ppf.impl.StudentServiceImpl;
import Ppf.pojo.Course;
import Ppf.pojo.Student;

/**
 * Servlet implementation class StudentLogin
 * ѧ����½�ӿ�
 */
@WebServlet("/studentLogin.do")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//step1:ѧ���ࡢ�˺����롢
		String _id=request.getParameter("username");
		int id=Integer.parseInt(_id);
		String password=request.getParameter("password");
//		
		//ServerResponse serverResponse=StudentServiceImpl.getInstance().studentLogin(id,password);
		//String responseText=serverResponse.obj2str();
		//System.out.print(responseText);
		//if(serverResponse.isSucess()) {
			//HttpSession session=request.getSession();	
			//session.setAttribute("student",serverResponse.getData()); //��½�ı�ʾ���Լ���½��ѧ����˭
//			//Ϊѧ������һ�����ﳵ��ѡ�ξͿ��Ի�ȡ�����ﳵ
//			session.setAttribute("cart", new ArrayList<Course>()); //��������ѧ����cart��cart��ֵ����new��course����
//			
		}
		/*PrintWriter pw=response.getWriter();
		pw.write(responseText);	
		pw.close();	*/	
	//}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
