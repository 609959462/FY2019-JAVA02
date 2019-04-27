package Ppf.common;

import com.google.gson.Gson;

public class ServerResponse<T> {                              //往前端返回这个封装的类

	private int status;
	private String msg;
	private T data;
	
	
	 private  ServerResponse() {}
	 
	 private  ServerResponse(int status) {
		this.status=status;
	}
	
	 private  ServerResponse(int status,String msg) {
		
		this.status=status;
		this.msg=msg;
	}
	
	 private  ServerResponse(int status,T data) {
		this.status=status;
		this.data=data;
    	
	}
	
	 private  ServerResponse(int status,String msg,T data) {
		this.status=status;
		this.data=data;
		this.msg=msg;
		
	}
  
	 
	 /**
	  * 判断接口是否调用成功
	  * */
	 
	 public   boolean isSucess() {
		 
		 return this.status==0;
	 }
	 
	 
	 /**
	  * status==0,接口调用成功.
	  * {status:0}
	  * 
	  * */
	 
	 public  static ServerResponse createServerResponseBySucess() {           //调用成功
		 
		 return new ServerResponse(0);
	 }
	 
	 /**
	  * {status:0,msg:""}
	  * */
	 
     public  static ServerResponse createServerResponseBySucess(String msg) {
		 
		 return new ServerResponse(0,msg);
	 }
	 
     /**
	  * {status:0,msg:"",data:}
	  * */
	 
     public  static <T> ServerResponse<T> createServerResponseBySucess(String msg,T data) {
		 
		 return new ServerResponse<T>(0,msg,data);
	 }
	 
	 
     /**
      * 接口调用失败
      * status !=0 
      * {status:  } 
      * */
     public  static ServerResponse createServerResponseByFail(int status) {
		 
		 return new ServerResponse(status);
	 }
     /**
	  * {status: ,msg:""}
	  * */
     public static ServerResponse createServerResponseByFail(int status,String msg) {
		 
		 return new ServerResponse(status,msg);
	 }

     
     public  String  obj2str() {                         //调用Gson包为了不去拼接   																				
			Gson gson=new Gson();                             //Gson包
			String responseText=gson.toJson(this);
    	    return responseText;
     }
     
     
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
