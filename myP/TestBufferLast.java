package myP;

public class TestBufferLast {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();	

		
		sb.append("12345\n");	// \n -> 5
//		sb.append("23456\n");	// \n -> 11
		
		
		if (sb.length() > 0) {								
			if(sb.lastIndexOf("\n", sb.length()-2)<0) {
				System.out.println("한줄이오");
				System.out.println(sb.toString());
			}
			else {
				System.out.println(sb.lastIndexOf("\n", sb.length()-2));	//10
				System.out.println(sb.lastIndexOf("\n", sb.length()-1));	//11
				System.out.println(sb.lastIndexOf("\n"));					//11
				System.out.print(sb.substring(sb.lastIndexOf("\n", sb.length()-2), sb.lastIndexOf("\n")));
			}
		}
		
//		String s = sb.toString();
//		
//		char[] ss = s.toCharArray();
//		int cnt = 0;
//		for(int i = 0 ; i < ss.length; i ++) {
//			System.out.printf("s[%d]:'%d'\n",i,(byte)ss[i]);
//		}
	}

}
