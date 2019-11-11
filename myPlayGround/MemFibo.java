package myPlayGround;

public class MemFibo {
	public static void main(String[] args) {
		System.out.println( "°á°ú"+fibonacci(20) );

	}

	public static int fibonacci(int x) {
		int[] data = new int[100];
		if (x <= 2) {
			return 1;
		} else {
			data[x] = fibonacci(x - 1) + fibonacci(x - 2);
			return data[x];
		}
	}
}
