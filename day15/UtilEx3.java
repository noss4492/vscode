package day15;

import java.util.Calendar;

public class UtilEx3 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// new �Ҽ� �� -> Calendar�� ����ƽ �޼��� getInstance
		int s = cal.get(Calendar.WEEK_OF_YEAR);
		int s1 = cal.get(Calendar.WEEK_OF_MONTH);
		int s2 = cal.get(Calendar.THURSDAY);
		int s3 = cal.get(Calendar.SECOND);
		
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("---------");
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.printf("%2d��%2d��%2d��%2d��%2d��\n",
				cal.get(2)+1, cal.get(5), 
				cal.get(10), cal.get(12), 
				cal.get(13));
//		cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), 
//		cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), 
//		cal.get(Calendar.SECOND));
		
		//
		
		long start = System.currentTimeMillis();
		
		String s9 ="";
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				for(int k = 1; k < 10; k++) {
					s9 += "*";
					System.out.print(s9+"|");
				}
				System.out.println();
			}
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println(Math.abs(start-end)+"ms");
		
//		
		// Calendar.DATE = 7 <<- �䷯�� ���ο��� ����� ���ǵǾ� ����
	}

}
