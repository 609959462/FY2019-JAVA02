package Ppf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Ppf.common.OperationEnum;
import Ppf.common.ServerResponse;
import Ppf.impl.CourseServiceimp;
import Ppf.service.ICourseSrivice;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			//返回客户端，operation参数必须传递  -》 json 
			//{"status":3,"msg":"operation参数必须传递 "}
			
			String responseText=ServerResponse.createServerResponseByFail(3, "参数必传").obj2str();
			
			pw.write(responseText);
			pw.close();
			
		}
		ICourseSrivice service=CourseServiceimp.getInstance();
		
		//string-int 
		try {
			int _operation=Integer.parseInt(operation);
			
		    if(_operation==OperationEnum.COURSE_ADD.getOperation_type()) {//添加课程
		    	
		    	String cid=request.getParameter("cid");
		    	try {
		    		int _cid=Integer.parseInt(cid);
		    		String cname=request.getParameter("cname");
		    		
		    		
		    		ServerResponse serverResponse=service.addCourse(_cid, cname);
		    
		    		pw.write(serverResponse.obj2str());
		    	}catch(NumberFormatException e) {
		    		
		    		String responseText="{\"status\":4,\"msg\":\"operation参数必须是数字 \"}";
					pw.write(responseText);
					pw.close();
		    		
		    	}
		    	
		    }else if(_operation==OperationEnum.COURSE_UPDATE.getOperation_type()) {//修改课程
		    	String cid=request.getParameter("cid");
		    	int _cid=Integer.parseInt(cid);
		    	String cname=request.getParameter("cname");
		    	ServerResponse serverResponse=service.updateCourse(_cid, cname);
		    	pw.write(serverResponse.obj2str());
		    	pw.close();
		    }else if(_operation==OperationEnum.COURSE_DELETE.getOperation_type()) {//删除课程
		    	String cid=request.getParameter("cid");
		    	int _cid=Integer.parseInt(cid);		    	
		    	ServerResponse serverResponse=service.deleteCourse(_cid);
		    	pw.write(serverResponse.obj2str());
		    	pw.close();
		    }else if(_operation==OperationEnum.COURSE_FINDALL.getOperation_type()) {//查看课程
		    	
		    	ServerResponse serverResponse=service.findCourse();
		    	pw.write(serverResponse.obj2str());
				pw.close();
		    }
		}catch(NumberFormatException e) {
			 //返回客户单，operation必须是数字
			
			//{"status":4,"msg":"operation必须是数字"}
			
			String responseText="{\"status\":4,\"msg\":\"operation参数必须是数字 \"}";
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
