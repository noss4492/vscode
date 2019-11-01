package day15;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UtilEx2 {
	public static void main(String[] args) {
		// ³¯Â¥
		Date d = new Date();
		
		System.out.println(2019-d.getYear());
		System.out.println(1900+d.getYear());
		System.out.println(1+d.getMonth());
		System.out.println(d.getDate());
		
		long start = System.currentTimeMillis();
		Random r = new Random();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String time2 = sdf.format(d);
		System.out.println(time2);
		
		System.out.println("ÀÏÄÉµµ¾¸:"+sdf.format(start));
		
		
		
		for(int i = 0; i <= 10; i++) {
			for(int j = i; j>0; j/=2)
				for(int k = i; k < 10; k*=2)
					System.out.printf("[k:%2d] ", k);
			System.out.println();
		}
		
		//deprecated : µý°Å ½á . . .
		
		
		
	}
}
