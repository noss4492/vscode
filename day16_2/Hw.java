package day16_2;

public class Hw {
	public static void main(String[] args) {
		call();
	}

	static void call() {	// 1. throws ClassCastException 
			String[] str = {"9","a","300","20"};
			
			int res = 0;
			// 2. try-catch
			for(int i = 0 ; i<str.length;i++){
				try {
					res += Integer.parseInt(str[i]);
					System.out.println("res : " + res);
				}catch(NumberFormatException nfe) {
					System.out.println("res : skip");
				}
			}
	}
}
