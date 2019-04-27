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
     * 处理管理员的请求----登陆注册
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
		request.setCharacterEncoding("UTF-8");                        //保证不是乱码
		response.setContentType("text/html;charset=UTF-8");           //这两个放在代码的第一句（防止乱码）	
		ServletContext serverContext=request.getServletContext();
//		PrintWriter pw1=response.getWriter();
//		ServletContext servletContext=request.getServletContext();      //获取全局域
//		Integer total=(Integer)servletContext.getAttribute("total");
//		if(total==null) {
//			total=1;      //此时没人在线----你就是1
//			servletContext.setAttribute("total", 1);
//		}else {
//			servletContext.setAttribute("total", ++total);
//		}
//		pw1.write("在线人数"+total);
		
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(10);//设置一个会话
		
		// TODO Auto-generated method stub
		//request.getMethod();
			
		//operation:1登陆  2注册
		
		String operation= request.getParameter("operation");             //获取参数operation
		 
		PrintWriter pw=response.getWriter();
		if(operation==null) {
			//String responseText="{\"status\":3,\"msg\":\"请做出选择\"}";                    //josn格式
			//按需要调用ServerResponse
			String responseText=ServerResponse.createServerResponseByFail(3, "请做出选择").obj2str();
			pw.write(responseText);                                                       //反应ServerResponse回去
			pw.close();
		}
		try {
			IAdminService service=new AdminService();
			int _operation=Integer.parseInt(operation);                 //假如operation不是个"123"的字符串会出现NumberFormatException
			//if(_operation==1) {                                        这样写可维护性会比较低，所以写成枚举类比较容易维护
			if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {	
				//登陆
//			String responseText="{\"status\":0,\"msg\":\"登陆\"}";                    //josn格式 （\转义的是”“）
//			pw.write(responseText);                                                       //反应回去
				//pw.close();
								
				
				
				String username =request.getParameter("username");							
				String password=request.getParameter("password"); 
				
				ServerResponse<Admin> serverResponse=service.login(username, password);		//判断登陆成功，直接用serverResponse判断		
				if(serverResponse.isSucess()) {                     //如果登陆成功
		    		//登录成功					
					session.setAttribute("user", serverResponse.getData());         //用来判断是否登陆过（根据session的JOSNID携带的数据）
		    		//会话域放这个数据
		    		//System.out.print(session.getAttribute("user"));
		    		
		    		//创建cooke
		    		Cookie username_cookie=new Cookie("username",username);//生成Cookie   value就是传进来的那个
		    		//设置cookie的过期时间
		    		username_cookie.setMaxAge(7*24*3600);                       //时间
		    		//将cookie写到客户端浏览器
		    		response.addCookie(username_cookie);						//把cookie写到客户端
		    		
		    		Cookie password_cookie=new Cookie("password",password);
		    		password_cookie.setMaxAge(7*24*3600);                             //时间
		    		response.addCookie(password_cookie);	   //把cookie写到客户端
		    	}
								
				pw.write(serverResponse.obj2str());				
//		    	if(issucc) {
//		    		
//		    		String responseText1=ServerResponse.createServerResponseByFail(0, "登陆成功").obj2str();                    //josn格式 （\转义的是”“）
//		    		pw.write(responseText1);                                                       //反应回去
//					pw.close();
//		    		
//		    		//返回客户端，登录成功
//		    		// {"status":0,"msg":"登录成功",data:{}}
//					
//		    	}else{//返回客户端，登录失败
//		    		//{"status":1,"msg":"登录失败"}
//		    		String responseText1="{\"status\":0,\"msg\":\"密码错误\"}";                    //josn格式 （\转义的是”“）
//					pw.write(responseText1);                                                       //反应回去
//					pw.close();
//		    	}
				//pw.write(responseText);
				//pw.close();
				
			
			//}
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {
				//注册
//				String responseText="{\"status\":0,\"msg\":\"请注册\"}";  
//				pw.write(responseText);
				//pw.close();
				
				String username =request.getParameter("username");							
				String password=request.getParameter("password"); 
				
				pw.write(RegisterDaoImpl.getInstance().register(username,password).obj2str());
				pw.close();
			}
			else if(_operation==OperationEnum.ADMIN_LAYOUT.getOperation_type()) {
		    	//退出登录
		    	session.removeAttribute("user");
		    	
		    }else if(_operation==OperationEnum.ADMIN_GET_MEMBER.getOperation_type()) {
		    	//获取在线人数                                                                                                           
		    	Integer total=(Integer)serverContext.getAttribute("total");
		    	//System.out.println("在线人数:"+total);
		    	String responseText=ServerResponse.createServerResponseBySucess("succ", total).obj2str();
		        pw.write(responseText);	
		    }}
		catch(NumberFormatException e){
			//必须是数字
			String responseText="{\"status\":4,\"msg\":\"必须是数字\"}";  
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
		doGet(request, response);                                       //放到一起，代码写一份就行了
}
}