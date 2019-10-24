package day07;
// 쓸모있는 메서드 만들기..
public class Method6 {
	/*
	public static int sum(int a, int b) {
		return a + b;
	}
	public static int avg(int a, int b) {
		return sum(a, b)/2;	//오차 있음
	}
	public static float avg(int a, int b, int c) {
		return (float)(a+b+c)/3;	//쓸모없는 sum...
	}
	*/
	/////////////////////////////////////////////
	
	//가변형 인수 (이건 좀 신기하네)
	public static int avg(int ... data) {	//data는 참조값임.
		int sum = 0;
		System.out.println("\n데이터에 들어있는 참조값 확인\ndata : "+data);
		System.out.println("---------------");
			
		for(int i = 0; i < data.length; i++) {
			System.out.printf("data[%02d] : %4d \n", i,  data[i]);
			sum += data[i];
		}
		
		return sum/data.length;
	}
	

	public static void main(String[] args) {

//		System.out.println("result sum1 : "+sum(100,200));
		System.out.println("\nresult avg1 : "+avg(100,200));
		System.out.println("\nresult avg2 : "+avg(100,200,300));
		System.out.println("\nresult avg3 :" +avg(100,200,300,400));
		System.out.println("\nresult avg3 :" +avg(100,200,300,400,500,600,700));
	}
}
