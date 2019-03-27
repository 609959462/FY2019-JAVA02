import java.util.Scanner;                //閿洏杈撳叆
class Student{     			 			//鍒涘缓瀛︾敓绫�
	public String name;                     //鍒涘缓瀛︾敓鐨勫睘鎬�
	public int id;
	public String sex;
	public int age;
	public String _class;
	public String address;
	public int phone;
	public String email;
//璁剧疆瀛︾敓淇℃伅
public void setName(String name){
	this.name=name;
}	
public void setSex(String sex){
	this.sex=sex;
}
public void setAddress(String address){
	this.address=address;
}
public void setAge(int age){
	this.age=age;
}
public void set_class(String _class){
	this._class=_class;
}
public void setPhone(int phone){
	this.phone=phone;
}
public void setId(int id){
	this.id=id;
}
public void setEmail(String email){
	this.email=email;
}
public String getName(){
	return name;
}
}



class Admin{                          //鍒涘缓绠＄悊鑰呯被   浠栫殑灞炴�у拰琛屼负閮藉啓鍦ㄨ繖閲岄潰
	public String username;					//鍒涘缓绠＄悊鑰呯被鐨勫睘鎬�
	public String password;
	
public Admin(String username,String password){                     //鏈夊弬鏋勯�犲嚱鏁�,瀹氫箟鐨勬椂鍊欏氨鏈夊�间簡
	this.username=username;
	this.password=password;
}	
public String getUsername(){                    //瀹氫箟绠＄悊鑰呯被鐨勬柟娉�
	return username;
}
public void setUsername(String username){       //璁剧疆鐢ㄦ埛鍚嶇殑鏂规硶
		this.username=username;             //褰㈠弬鍜屾垚鍛樺彉閲忎竴鏍凤紝鐢╰his鍖哄垎   淇敼瀵嗙爜鍚庝笉闇�瑕佽繑鍥炰笢瑗�
}
public String getPassword(){
	return password;
}
public void setPassword(String password){
	 this.password=password;
}
}

public class StudentMangagement{                  //澶х被
	public static void main(String[] args){
		StudentMangagement stu=new StudentMangagement();
		Student std=new Student();
		welcome();
		
		Admin[] admins=new Admin[3]; 
		
		initData(admins); 
		
		//璋冪敤鏂规硶
		operation(admins);
		stu.look();
		stu.select();
		System.out.println(std.getName());
	}
	public static void initData(Admin[] admins){
	/*	Admin[] admins=new Admin[3];              //new涓�涓鐞嗗憳鏁扮粍 */
		Admin admin=new Admin("zs","admin");				//new 涓�涓璞� 骞朵笖瑕佺粰浠栬祴鍊�
		Admin admin1=new Admin("ls","admin");				//new 涓�涓璞� 骞朵笖瑕佺粰浠栬祴鍊�
		Admin admin2=new Admin("ww","admin");				//new 涓�涓璞� 骞朵笖瑕佺粰浠栬祴鍊�
		
		
		
		admins[0]=admin;
		admins[1]=admin1;
		admins[2]=admin2;
	}
	
	public static void operation(Admin[] admins){
	Scanner s =new Scanner(System.in);     //1銆�40銆�41涓昏鏄帴鍙楅敭鐩樿緭鍏�
	System.out.print("璇烽�夋嫨");
	int operation=s.nextInt();
	if(operation==1){
		logic(admins);
	}else if(operation==2){
			System.exit(0);
	}else{
	System.out.println("杈撳叆鏈夎,璇烽噸鏂拌緭鍏�");
	operation(admins);                               //閫掑綊姝ゆ柟娉�
		}
	}
	
	public static void welcome(){
	System.out.println("               娆㈣繋鐧婚檰");
	System.out.println("            1.鐧婚檰   2.閫�鍑�");
}
	public static void logic(Admin[] admins){
		//System.out.println("娆㈣繋鐧婚檰");
		Scanner s =new Scanner(System.in);     
		System.out.print("璇疯緭鍏ョ敤鎴峰悕");
		String username=s.nextLine();
		System.out.print("璇疯緭鍏ュ瘑鐮�");
		String password=s.nextLine();
		for(int i=0;i<admins.length;i++){            //浣嗘槸admins浣滅敤鍩熸槸鍦╩ain涓紝杩欎釜鏂规硶鐢ㄤ笉鍒帮紝鍥犳鍊掔潃缁欎娇鐢ㄤ粬鐨勪汉閮藉姞涓奱dmins杩欎釜鍙傛暟銆�
			Admin admin=admins[i];
			if(admin==null){
				continue;
			}
			if(username.equals(admin.username)&&password.equals(admin.password)){
				System.out.print("娆㈣繋鎮�"+username+"鍏堢敓");
				break;
			}
			else{
				System.out.println("璇烽噸鏂拌緭鍏�");
				logic(admins);
				break;
			}
			
			}
		}
	public void look(){
		System.out.println("");
		System.out.println("********************璇烽�夋嫨瑕佹搷浣滅殑淇℃伅瀵瑰簲鏁板瓧********************");
		System.out.print("*1.鏌ョ湅瀛︾敓淇℃伅    *2.娣诲姞瀛︾敓淇℃伅     *3.鍒犻櫎瀛︾敓淇℃伅   *4.淇敼瀛︾敓淇℃伅    *5.閫�鍑� ");
	}
	public void select(){
		Scanner s =new Scanner(System.in);  
		System.out.println("");
		System.out.print("璇烽�夋嫨:");
		int select=s.nextInt();
		if(select==1){
			see();
		}
		if(select==2){
			System.out.println("璇疯緭鍏ュ鐢烮D");
			Scanner s1 =new Scanner(System.in);
			int ss1=s1.nextInt();
				if(ss1==3){
					System.out.println("姝d3瀛樺湪璇烽噸鏂拌緭鍏�");
				}
			add();
		}
		if(select==3){
			
		}
		if(select==4){
			Scanner s2 =new Scanner(System.in);
			int inf=s2.nextInt();
			System.out.println("1*鏍规嵁ID淇敼瀛︾敓鐨勫叏閮ㄤ俊鎭�      2*鏍规嵁ID淇敼瀛︾敓鐨勯儴鍒嗕俊鎭�        3*杩斿洖涓婄骇鐩綍      4*绯荤粺閫�鍑�");
			
		}
		if(select==5){
			System.exit(0);
		}
	}
	public void see(){							//鏌ョ湅瀛︾敓淇℃伅
		System.out.print("");
	}
	public void add(){
		Admin adminss[]=new Admin[1];
		//娣诲姞瀛︾敓淇℃伅
		Student s=new Student();
		Scanner s1 = new Scanner(System.in);
		System.out.println("璇疯緭鍏ユ坊鍔犵殑瀛︾敓id");
        int id = s1.nextInt();
		s.setAge(id);
		
		System.out.println("璇疯緭鍏ュ鐢熷鍚�");
        String name = s1.next();
		s.setName(name);
		
		System.out.println("璇疯緭鍏ュ鐢熸�у埆");
        String sex = s1.next();
		s.setSex(sex);
		
		System.out.println("璇疯緭鍏ュ鐢熷勾榫�");
        int age = s1.nextInt();
		s.setAge(age);
		            
		System.out.println("璇疯緭鍏ュ鐢熷勾绾�");
        String _class = s1.next();
		s.set_class(_class);                                       //娣诲姞瀛︾敓
		
		System.out.println("璇疯緭鍏ュ鐢熷湴鍧�");
        String address = s1.next();
		s.setAddress(address);
		
		System.out.println("璇疯緭鍏ュ鐢熻仈绯绘柟寮�");
        int phone = s1.nextInt();
		s.setPhone(phone);
		
		System.out.println("璇疯緭鍏ュ鐢熺殑鐢靛瓙閭");
        String email = s1.next();
		s.setEmail(email);
		
		System.out.println("鏁版嵁淇濆瓨鎴愬姛锛岀郴缁熷皢鑷姩杩斿洖涓婂眰鐩綍~");
		look();
		
		
	}	
	
	}
	