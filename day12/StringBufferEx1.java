package day12;
//Object String StringBuffer
public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM EMP");
		sb.append("WHERE deptno = 10");
		
		System.out.println(sb.toString());
		
		System.out.println(sb.reverse());
	}

}
