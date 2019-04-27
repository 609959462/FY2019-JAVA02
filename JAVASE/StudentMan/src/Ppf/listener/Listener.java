package Ppf.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * 获取在线人数，不能用session因为，这个是一个浏览器的，需要所有的浏览器的、所有用户的
	 * 
	 * 
	 * 
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     *  向session中添加属性时，会调用该方法。
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {   //监听event
         // TODO Auto-generated method stub   		
    		ServletContext serverContext= event.getSession().getServletContext();  //用户登陆后改变了全局变量的值
    		if(event.getName().equals("user")) {
    		//有用户登录成功
    		Integer total=(Integer)serverContext.getAttribute("total");
    		if(total==null) {
    			total=1;
    			serverContext.setAttribute("total", 1);
    		}else {
    			serverContext.setAttribute("total", ++total);
    		}
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     * 从session中移除属性时，会调用该方法
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	ServletContext serverContext= event.getSession().getServletContext();
    	Integer num=(Integer)serverContext.getAttribute("total");
    	if(num==null) {                 //Integer对象
    		num=0;
    	}else {
    		num--;
    	}
    	if(num<=0) {
    		num=0;
    	}
    	serverContext.setAttribute("total", num);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     * 当替换session中的属性时，会调用该方法
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	
         // TODO Auto-generated method stub                    //修改时
    	HttpSession session= event.getSession();
    	Object o=session.getAttribute("user");
    	if(o!=null) {                //防止同一个用户
    		return;
    	}
    	ServletContext serverContext=session.getServletContext();    //拿到全局域
    	
    	if(event.getName().equals("user")) {
    		//有用户登录
    		Integer total=(Integer)serverContext.getAttribute("total");
    		if(total==null) {
    			total=1;
    			serverContext.setAttribute("total", 1);
    		}else {
    			serverContext.setAttribute("total", ++total);
    		}
    	}
    }
	
}
