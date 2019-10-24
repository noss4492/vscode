package day02;
import java.util.Scanner;
// 신체검사 데이터용 클래스 배열에서 평균 키와 시력의 분포를 구함

class will_delete {

	static final int VMAX = 21;		// 시력 분포(0.0에서 0.1 단위로 21개）

	static class PhyscData {
		String name;				// 이름
		int    height;				// 키
		double vision;				// 시력

		// 생성자
		PhyscData(String name, int height, double vision) {
			this.name 	= name;
			this.height = height;
			this.vision = vision;
		}
	}

	// 키의 평균값을 구함
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;

		for (int i = 0; i < dat.length; i++)
			sum += dat[i].height;

		return sum / dat.length;
	}

	// 시력 분포를 구함
	static void distVision(PhyscData[] dat,
								  int[] dist) {
		int i = 0;

		dist[i] = 0;
		for (i = 0; i < dat.length; i++)
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
				dist[(int)(dat[i].vision * 10)]++;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		PhyscData[] x = {
			new PhyscData("박현규", 162, 0.3),
			new PhyscData("함진아", 173, 0.7),
			new PhyscData("최윤미", 175, 2.0),
			new PhyscData("홍연의", 171, 1.5),
			new PhyscData("이수진", 168, 0.4),
			new PhyscData("김영준", 174, 1.2),
			new PhyscData("박용규", 169, 0.8),
		};
		int[] vdist = new int[VMAX];					// 시력 분포

		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름         키       시력");
		System.out.println("---------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n",
												  x[i].name, x[i].height, x[i].vision);

		System.out.printf("\n평균 키：%5.1fcm\n", aveHeight(x));

		distVision(x, vdist);							// 시력 분포를 구함

		System.out.println("\n시력 분포");
		for (int i = 0; i < VMAX; i++)
			System.out.printf("%3.1f~：%2d명\n", i / 10.0, vdist[i]);
	}
}




/*
 * package day02; import java.util.Scanner; //package chap02;
 * 
 * 
 * 
 * 클래스 생성 연습임.
 * 
 * 출력 예
 * 
 * 이름 키 시력
 * 
 * 
 * 시력분포 0.0~:0명 0.1~:0명 0.2~:0명 ... 0.5:~0명 --------
 * 
 * 
 * //신체검사 데이터용 클래스 배열 에서 //평균 키와 시력 분포를 구함
 * 
 * class will_delete{
 * 
 * static final int VMAX = 21; // distribution of vision 21 level 0.0 ~ 2.0
 * 
 * static class PhyscData{ // student data format String name; int height;
 * double vision;
 * 
 * // Generator PhyscData(String name, int height, double vision){ this.name =
 * name; this.height = height; this.vision = vision; } }
 * 
 * // avg height of all student static double avgHight(PhyscData[] dat){ double
 * sum = 0;
 * 
 * for( int i=0; i<dat.length; i++) // 확장 for문 사용해볼 것 sum += dat[i].height;
 * 
 * return sum / dat.length; }
 * 
 * // distribution of vision static void distVision(PhyscData[] dat, int[]
 * dist){ int i =0; dist[i] = 0; for (i = 0; i<dat.length; i++) if
 * (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
 * dist[(int)(dat[i].vision*10)]++; }
 * 
 * 
 * // main method public static void main(String[] args){ Scanner stdIn = new
 * Scanner(System.in);
 * 
 * PhyscData[] x = { new PhyscData("박현규", 162, 0.3), new PhyscData("함진아", 173,
 * 0.7), new PhyscData("최윤미", 175, 2.0), new PhyscData("홍연의", 171, 1.5), new
 * PhyscData("이수진", 168, 0.4), new PhyscData("김영준", 174, 1.2), new
 * PhyscData("박용규", 169, 0.8), }; int[] vdist = new int[VMAX];
 * 
 * System.out.println("--신체검사 학생 리스트--");
 * System.out.println("이름          키          시력");
 * System.out.println("---------------");
 * 
 * for(int i = 0; i<x.length; i++) //확장 for문으로 변경할 것
 * System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
 * 
 * System.out.printf("\n평균 키 : %5.1fcm\n", avgHight(x));
 * 
 * distVision(x, vdist);
 * 
 * System.out.println("\n시력 분포"); for(int i=0; i<VMAX; i++)
 * System.out.printf("%3.1f~ :%2d명\n", i/10.0, vdist[i]);
 * 
 * } }
 * 
 * 
 * 
 * // 자바 스타일 익히기 // 변수 이름 적어두고 새로 재구성해보기 // 테이블 컬럼 name, height, vision // dist
 * vision // VMAX 는 distribution of vision
 * 
 * "박현규", 162, 0.3 "함진아", 173, 0.7 "최윤미", 175, 2.0 "홍연의", 171, 1.5 "이수진", 168,
 * 0.4 "김영준", 174, 1.2 "박용규", 169, 0.8
 * 
 * //
 * 
 * 
 * 
 * // Q. // 신체검사 데이터용 클래스 배열 에서 // 평균 키와 시력 분포를 구하라 // 다음과 같은 출력을 만들어라
 * 
 * 
 * // 무엇이 필요할까? 생각해보고 작성하도록 하장. // 클래스를 만들자 // 클래스 내부 // 1. 필드 // 1. 필드부 정의 //
 * 전역 상수 설정 // 데이터 포맷 // 생성자로 클래스, 인스턴스 초기화 // 2-1. 매서드 // 2-2. 메인(메인메서드)
 * 
 * public class will_delete{
 * 
 * 
 * 
 * // 전역 상수 static final int VmaxLv = 21; // 시력 0.0 ~ 2.0 21 Lv로 양자화, 너비:0.1
 * 
 * // 데이터 포맷 정의, 왜냐? 테이블에 담길 자료형을 하나 만들어서 row별로 관리하기 위해서지 public static
 * PhysicalData() { String name; int height; float vision;
 * 
 * // 생성자, 클래스 및 인스턴스 초기화 PhysicalData(String name, int height, float vision){
 * this.name = name; this height = height; this vision = vision; } }
 * 
 * public static void main(String[] args) { Scanner stdIn = new
 * Scanner(System.in);
 * 
 * PhysicalData[] pd = { "박현규", 162, 0.3 "함진아", 173, 0.7 "최윤미", 175, 2.0 "홍연의",
 * 171, 1.5 "이수진", 168, 0.4 "김영준", 174, 1.2 "박용규", 169, 0.8 }; int[] vdist = new
 * int[VMAX];
 * 
 * System.out.println("■ 신체검사 리스트 ■");
 * System.out.println(" 이름         키       시력");
 * System.out.println("---------------"); for (int i = 0; i < pd.length; i++)
 * System.out.printf("%-8s%3d%5.1f\n", pd[i].name, pd[i].height, pd[i].vision);
 * 
 * System.out.printf("\n평균 키：%5.1fcm\n", aveHeight(VmaxLv));
 * 
 * distVision(VmaxLv, vdist); // 시력 분포를 구함
 * 
 * System.out.println("\n시력 분포"); for (int i = 0; i < VmaxLv; i++)
 * System.out.printf("%3.1f~：%2d명\n", i / 10.0, vdist[i]); } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */