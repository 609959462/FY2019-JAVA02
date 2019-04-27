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
	 * ��ȡ����������������session��Ϊ�������һ��������ģ���Ҫ���е�������ġ������û���
	 * 
	 * 
	 * 
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     *  ��session���������ʱ������ø÷�����
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {   //����event
         // TODO Auto-generated method stub   		
    		ServletContext serverContext= event.getSession().getServletContext();  //�û���½��ı���ȫ�ֱ�����ֵ
    		if(event.getName().equals("user")) {
    		//���û���¼�ɹ�
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
     * ��session���Ƴ�����ʱ������ø÷���
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	ServletContext serverContext= event.getSession().getServletContext();
    	Integer num=(Integer)serverContext.getAttribute("total");
    	if(num==null) {                 //Integer����
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
     * ���滻session�е�����ʱ������ø÷���
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	
         // TODO Auto-generated method stub                    //�޸�ʱ
    	HttpSession session= event.getSession();
    	Object o=session.getAttribute("user");
    	if(o!=null) {                //��ֹͬһ���û�
    		return;
    	}
    	ServletContext serverContext=session.getServletContext();    //�õ�ȫ����
    	
    	if(event.getName().equals("user")) {
    		//���û���¼
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
