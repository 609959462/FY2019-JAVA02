package Ppf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ppf.common.OperationEnum;
import Ppf.common.OperationStudent;
import Ppf.common.ServerResponse;
import Ppf.impl.StudentServiceImpl;
import Ppf.pojo.Admin;
import Ppf.pojo.Student;
import Ppf.service.IStudentService;

/**
 * Servlet implementation class StudentServelt
 */
@WebServlet("/student.do")
public class StudentServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//�鿴ѧ��
		//operation:1.�鿴ȫ��ѧ��  2.�鿴����ѧ�� 3.
 		String operation= request.getParameter("operation");             //��ȡ����operation
		PrintWriter pw=response.getWriter();                             //��ӡ���
		//IStudentService userViewimpl=new StudentServiceImpl();
		if(operation==null) {
			String responseText=ServerResponse.createServerResponseByFail(3, "������ѡ��").obj2str();
			pw.write(responseText);                                                       //��ӦServerResponse��ȥ
			pw.close();
		}
		int _operation=Integer.parseInt(operation);
		if(_operation==OperationStudent.Find_ALLSTUDENT.getOperation_type()) {
			//�鿴ȫ��ѧ����Ϣ
			
			ServerResponse<Student> serverResponse=StudentServiceImpl.getInstance().look();	
			pw.write(serverResponse.obj2str());
		}
		if(_operation==OperationStudent.Find_PARTSTUDENT.getOperation_type()) {
			//�鿴����ѧ����Ϣ
			String operation1= request.getParameter("operation1");
			String n= request.getParameter("num");
			int num1=Integer.parseInt(n);   
		//	ServerResponse<Student> serverResponse=StudentServiceImpl.getInstance().lookPart(operation1,num1);	
		//	pw.write(serverResponse.obj2str());
		}
		if(_operation==OperationStudent.ADD_STUDENT.getOperation_type()) {
			//���ѧ��
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int sex=Integer.parseInt(request.getParameter("sex"));
			int age=Integer.parseInt(request.getParameter("age"));
			String _class=request.getParameter("_class");
			String address=request.getParameter("address");
			int phone=Integer.parseInt(request.getParameter("phone"));
			String email=request.getParameter("email");
			int scores=Integer.parseInt(request.getParameter("scores"));
			long Date=System.currentTimeMillis();	
			String password=request.getParameter("password");
			ServerResponse<Student> serverResponse=StudentServiceImpl.getInstance().add(id,name,sex,age,_class,address,phone,email,scores,password);	
			pw.write(serverResponse.obj2str());
		}
		if(_operation==OperationStudent.DELECT_STUDENT.getOperation_type()) {
			//ɾ��ѧ��
			String operation1= request.getParameter("operation1");
			int m=Integer.parseInt(request.getParameter("operation1"));
			ServerResponse<Student> serverResponse=StudentServiceImpl.getInstance().delect(m);
			pw.write(serverResponse.obj2str());
		}
		if(_operation==OperationStudent.MODIFYID_STUDENT.getOperation_type()) {
			//�޸�ѧ����Ϣ
			
			int id=Integer.parseInt(request.getParameter("id"));//��ȡID
			int id1=Integer.parseInt(request.getParameter("id1"));
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			int sex1=Integer.parseInt(sex);
			int age=Integer.parseInt(request.getParameter("age"));
			String _class=request.getParameter("_class");
			String address=request.getParameter("address");
			int phone=Integer.parseInt(request.getParameter("phone"));
			String email=request.getParameter("email");
			int scores=Integer.parseInt(request.getParameter("scores"));
			ServerResponse<Student> serverResponse=StudentServiceImpl.getInstance().correct(id,name,sex1,age,_class,address,phone,email,scores);	
			pw.write(serverResponse.obj2str());	
			
		}
//		if(_operation==OperationStudent.MODIFY_STUDENT.getOperation_type()) {
//			//����ID�޸�ѧ����Ϣ
//		}
	}

	

}
