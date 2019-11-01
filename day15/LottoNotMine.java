package day15;

public class LottoNotMine {
	public static void main(String[] args) {
		int[] rnd = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
				28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45 };

		for (int i = 1; i < 1000; i++) {
			int num1 = (int) (Math.random() * 45);
			int num2 = (int) (Math.random() * 45);

			int temp = 0;

			temp = rnd[num1];
			rnd[num1] = rnd[num2];
			rnd[num2] = temp;

		}// for¹® end 
		for(int i =0; i<6;i++) {
			System.out.print(rnd[i]+"\t");
		}
		System.out.println();
	}// main method end 
	
}// class end 







