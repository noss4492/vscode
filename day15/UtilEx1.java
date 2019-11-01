package day15;

import java.util.Random;

public class UtilEx1 {
	public static void main(String[] args) {
		Random rnd = new Random();
		rnd.setSeed(1);
		
		System.out.println(rnd);
		for(int j = 0; j < 5; j++) {	
			System.out.println();
			for(int i = 0; i < 5; i++)
				System.out.print(" "+rnd.nextInt(45));
		}
		
	}

}
