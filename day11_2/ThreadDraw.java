package day11_2;

public class ThreadDraw {
	public static void main(String[] args) {
		new MyWinMy();
		MyWinMy t = new MyWinMy();
		Thread t2 = new Thread(t);
		t2.start();
	}
}
