package day07;

public class Method5 {
	
	public static void resetArr(int[] x) {
		for(int i = 0; i < x.length; i++)
			x[i] = 0;
	}

	public static void main(String[] args) {
		int[] m = {100, 200, 300};
		
		for(int i = 0; i < m.length; i++)
			System.out.printf("m[%1d] : %3d \n",i , m[i]);
		
		resetArr(m);
		
		for(int i = 0; i < m.length; i++)
			System.out.printf("m[%1d] : %3d \n",i , m[i]);

	}

}
