package day07;
// �����ִ� �޼��� �����..
public class Method6 {
	/*
	public static int sum(int a, int b) {
		return a + b;
	}
	public static int avg(int a, int b) {
		return sum(a, b)/2;	//���� ����
	}
	public static float avg(int a, int b, int c) {
		return (float)(a+b+c)/3;	//������� sum...
	}
	*/
	/////////////////////////////////////////////
	
	//������ �μ� (�̰� �� �ű��ϳ�)
	public static int avg(int ... data) {	//data�� ��������.
		int sum = 0;
		System.out.println("\n�����Ϳ� ����ִ� ������ Ȯ��\ndata : "+data);
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
