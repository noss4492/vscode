package day08HW;

public class FormatData {	// 포맷 데이타?
	void print(int a) {
		System.out.println(a);
	}
	void print(int[] b) {	// int ... a  or  int []  or int,int,int,int
		System.out.print("[ ");
		for(int x : b)
			System.out.print(x+" ");
		System.out.println("]");
	}
	void print(float f) {
		System.out.println(f);
	}
}
