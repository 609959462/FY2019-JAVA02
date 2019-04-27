package Ppf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Ppf.common.ServerResponse;
import Ppf.impl.Limit;
import Ppf.impl.StudentChoise;
import Ppf.pojo.Course;
import Ppf.pojo.Student;
import Ppf.service.IStudentChoiseCourseService;

/**
 * Servlet implementation class ChoiceServelt
 */
@WebServlet("/choice")
public class ChoiceServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiceServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession();//��ȡ���Ự��Ҳ����ζ�Ż�ȡ���˹��ﳵ��ѧ����Ϣ
		 List<Course> courses=(List<Course>)session.getAttribute("cart");//���ﳵ����ǿγ̼��ϣ�����ת��
		 Student student=(Student) session.getAttribute("student");  //��ȡ��ѧ�������Ĺ��ﳵ
		 
		 PrintWriter pw=response.getWriter();
		 System.out.print(pw);
			String operation=request.getParameter("operation");
			try {
			if(operation==null) {
				//���ؿͻ��ˣ�operation�������봫��  -�� json 
				//{"status":3,"msg":"operation�������봫�� "}
				String responseText=ServerResponse.createServerResponseByFail(3, "�����ش�").obj2str();			
				pw.write(responseText);
				pw.close();				
			}
			int _operation=Integer.parseInt(operation);
			if(_operation==1) {//ѡ��
				//��ȡ��ѧ���ĻỰ��Ϣ				 
				 //ѧ��ѡ��			 					 
			 	 String cid=request.getParameter("cid");
			 	 int _cid=Integer.parseInt(cid);
			 	int id=student.getId();
				 ServerResponse serverResponse= StudentChoise.getInstance().choiseCourse(id,_cid);				
				 pw.write(serverResponse.obj2str());
			}else if(_operation==2) {//�鿴ѧ��ѡ��Ŀγ�
				
				String responseText=ServerResponse.createServerResponseBySucess("succ", courses).obj2str();
				pw.write(responseText);
			}else if(_operation==3) {//�鿴��ѡѡ��γ�
				int id=student.getId();
				ServerResponse serverResponse= StudentChoise.getInstance().see(id);
				pw.write(serverResponse.obj2str());
				//System.out.print(serverResponse.obj2str());
			}else if(_operation==4) {//����idɾ���γ�
				int id=student.getId();
				String cid=request.getParameter("cid");
				int _cid=Integer.parseInt(cid);
				ServerResponse serverResponse= StudentChoise.getInstance().delete(id,_cid);
				pw.write(serverResponse.obj2str());
			}else if(_operation==5) {//��ҳ�鿴
				int id=student.getId();				
				String _PageNo=request.getParameter("PageNo");
				int PageNo=Integer.parseInt(_PageNo);
				int PageSize=2;
				ServerResponse serverResponse=Limit.getInstance().limitBySid(id, PageNo, PageSize);
				System.out.print(serverResponse.obj2str());
				pw.write(serverResponse.obj2str());				
			}
			
	     }catch(NumberFormatException e) {
		String responseText="{\"status\":4,\"msg\":\"����������\"}";  
		pw.write(responseText);
		pw.close();
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
