package day05;

public class rand {

	public static void main(String[] args) {
		int[] rnd = new int[45];
		
		for(int i = 0; i < 45; i++)
			rnd[i] = i+1;
		
		for(int i = 1; i < 10000; i++) {
			int n1 = (int)(Math.random()*45);
			int n2 = (int)(Math.random()*45);
			if(n2==n1)
				continue;
			
			int tmp = 0;
			
			System.out.printf("ÀÚ¸®¹Ù²Ş Àü %2d | %2d \n",n1 ,n2);
			tmp = rnd[n1];
			rnd[n1] = rnd[n2];
			rnd[n2] = tmp;
			System.out.printf("ÀÚ¸®¹Ù²Ş ÈÄ %2d | %2d \n",n1 ,n2);
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(rnd[i] + "\t");
		}

	}

}
