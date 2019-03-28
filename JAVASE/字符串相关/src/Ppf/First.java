package Ppf;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub   
		/*String st="test";        String转StringBuffer（test翻转）
		StringBuffer b=new StringBuffer(st);
		b.reverse();
		System.out.println(b);
		String st="ACbhsa14";
			int a=0;
			int b=0;
			int c=0;
			
		for(int i=0;i<st.length()-1;i++) {
			char d= st.charAt(i);      //字符相比较，用char
			if(d>'a'&&d<'z') {
				System.out.println(d);
			}
		}
		
	}*/
		/*String s="aasda";
		String b="aasda";
		for(int i=0;i<s.length()-1;i++) {
			char d= s.charAt(i);
			for(int j=0;j<b.length()-1;j++) {
				char m= s.charAt(i);
				if(s=d) {
					
				}
			}
		}
		}
	}	*/
		String s="asdsqwewqrasd";
		int b=0;
		while(s.indexOf("asd")!=-1) {
			s=s.substring(s.indexOf("asd")+3);
			b++;
		}
		System.out.println(b);
}}